package com.baidu.ar.b;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
/* loaded from: classes3.dex */
public final class a {
    private static a a;
    private static HandlerThread f;
    private static Handler h = new Handler(Looper.getMainLooper());
    private static Runnable i = new Runnable() { // from class: com.baidu.ar.b.a.1
        @Override // java.lang.Runnable
        public void run() {
            if (a.f != null) {
                a.f.quit();
                HandlerThread unused = a.f = null;
            }
        }
    };
    private MediaPlayer b;
    private Map<String, MediaPlayer> e;
    private Handler g;
    private int c = 0;
    private boolean d = false;
    private Handler.Callback j = new Handler.Callback() { // from class: com.baidu.ar.b.a.2
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 3004:
                    a.this.a(message);
                    return false;
                case 3005:
                    a.this.b(message);
                    return false;
                case 3006:
                    a.this.c(message);
                    return false;
                case 3007:
                    a.this.d(message);
                    return false;
                case 3008:
                    a.this.e(message);
                    return false;
                default:
                    return false;
            }
        }
    };

    /* renamed from: com.baidu.ar.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0026a {
        void a(Exception exc);

        void a(boolean z);
    }

    /* loaded from: classes3.dex */
    class b implements InterfaceC0026a {
        InterfaceC0026a a;

        b(InterfaceC0026a interfaceC0026a) {
            this.a = interfaceC0026a;
        }

        @Override // com.baidu.ar.b.a.InterfaceC0026a
        public void a(final Exception exc) {
            if (this.a == null) {
                return;
            }
            a.h.post(new Runnable() { // from class: com.baidu.ar.b.a.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a.a(exc);
                }
            });
        }

        @Override // com.baidu.ar.b.a.InterfaceC0026a
        public void a(final boolean z) {
            if (this.a == null) {
                return;
            }
            a.h.post(new Runnable() { // from class: com.baidu.ar.b.a.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a.a(z);
                }
            });
        }
    }

    private a() {
        synchronized (a.class) {
            if (f == null) {
                f = new HandlerThread("MediaPlayerThread");
                f.start();
            } else {
                h.removeCallbacks(i);
            }
        }
        this.g = new Handler(f.getLooper(), this.j);
    }

    private MediaPlayer a(MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioStreamType(3);
            if (onCompletionListener == null) {
                onCompletionListener = new MediaPlayer.OnCompletionListener() { // from class: com.baidu.ar.b.a.3
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public void onCompletion(MediaPlayer mediaPlayer2) {
                    }
                };
            }
            mediaPlayer.setOnCompletionListener(onCompletionListener);
            if (onErrorListener == null) {
                onErrorListener = new MediaPlayer.OnErrorListener() { // from class: com.baidu.ar.b.a.4
                    @Override // android.media.MediaPlayer.OnErrorListener
                    public boolean onError(MediaPlayer mediaPlayer2, int i2, int i3) {
                        com.baidu.ar.util.b.d("error code = " + i2 + ", extra = " + i3);
                        return false;
                    }
                };
            }
            mediaPlayer.setOnErrorListener(onErrorListener);
            return mediaPlayer;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static MediaPlayer a(MediaPlayer mediaPlayer, String str, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, int i2) {
        if (!TextUtils.isEmpty(str) || assetFileDescriptor != null) {
            com.baidu.ar.util.b.a("file path = " + str);
            if (mediaPlayer != null) {
                if (onCompletionListener != null) {
                    mediaPlayer.setOnCompletionListener(onCompletionListener);
                }
                try {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.seekTo(0);
                        mediaPlayer.stop();
                    }
                    mediaPlayer.setAudioStreamType(3);
                    mediaPlayer.reset();
                    if (!TextUtils.isEmpty(str)) {
                        mediaPlayer.setDataSource(str);
                    } else if (assetFileDescriptor != null) {
                        mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
                    }
                    mediaPlayer.prepare();
                    mediaPlayer.seekTo(0);
                    mediaPlayer.setLooping(i2 <= 0);
                    mediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (IllegalArgumentException e2) {
                    e2.printStackTrace();
                } catch (IllegalStateException e3) {
                    e3.printStackTrace();
                } catch (SecurityException e4) {
                    e4.printStackTrace();
                }
            }
        }
        return mediaPlayer;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (a == null) {
                a = new a();
            }
            aVar = a;
        }
        return aVar;
    }

    private void a(InterfaceC0026a interfaceC0026a, String str, String str2, AssetFileDescriptor assetFileDescriptor, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener, int i2) {
        try {
            MediaPlayer a2 = a(str, onCompletionListener, onErrorListener);
            if (a2 != null) {
                a(a2, str2, assetFileDescriptor, onCompletionListener, i2);
            }
            if (interfaceC0026a != null) {
                interfaceC0026a.a(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            MediaPlayer a3 = a(str);
            b(str);
            if (a3 != null) {
                try {
                    a3.release();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    if (interfaceC0026a != null) {
                        interfaceC0026a.a(e2);
                        return;
                    }
                    return;
                }
            }
            try {
                MediaPlayer a4 = a().a(str, onCompletionListener, onErrorListener);
                if (a4 != null) {
                    a(a4, str2, assetFileDescriptor, onCompletionListener, i2);
                }
                if (interfaceC0026a != null) {
                    interfaceC0026a.a(true);
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                if (interfaceC0026a != null) {
                    interfaceC0026a.a(e3);
                }
            }
        }
    }

    public static synchronized void b() {
        synchronized (a.class) {
            a = null;
            h.postDelayed(i, 10000L);
        }
    }

    private void c(InterfaceC0026a interfaceC0026a, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i2) {
        MediaPlayer a2 = a(str);
        b(str);
        if (a2 != null) {
            try {
                a2.release();
            } catch (Exception e) {
                e.printStackTrace();
                if (interfaceC0026a != null) {
                    interfaceC0026a.a(e);
                    return;
                }
                return;
            }
        }
        try {
            MediaPlayer a3 = a(str, onCompletionListener, null);
            if (a3 != null) {
                a(a3, str2, (AssetFileDescriptor) null, onCompletionListener, i2);
            }
            if (interfaceC0026a != null) {
                interfaceC0026a.a(true);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            if (interfaceC0026a != null) {
                interfaceC0026a.a(e2);
            }
        }
    }

    public MediaPlayer a(String str) {
        if (this.e == null || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.e.get(str);
    }

    public MediaPlayer a(String str, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.e == null || !this.e.containsKey(str)) {
            MediaPlayer a2 = a(onCompletionListener, onErrorListener);
            if (a2 != null) {
                if (this.e == null) {
                    this.e = new Hashtable();
                }
                this.e.put(str, a2);
                return a2;
            }
            return null;
        }
        return this.e.get(str);
    }

    public void a(Message message) {
        Object[] objArr = (Object[]) message.obj;
        a((InterfaceC0026a) objArr[0], (String) objArr[1], (String) objArr[2], null, (MediaPlayer.OnCompletionListener) objArr[3], null, ((Integer) objArr[4]).intValue());
    }

    public void a(InterfaceC0026a interfaceC0026a) {
        Message obtainMessage = this.g.obtainMessage(3008);
        obtainMessage.obj = new Object[]{new b(interfaceC0026a)};
        obtainMessage.sendToTarget();
    }

    public void a(InterfaceC0026a interfaceC0026a, String str) {
        Message obtainMessage = this.g.obtainMessage(3006);
        obtainMessage.obj = new Object[]{new b(interfaceC0026a), str};
        obtainMessage.sendToTarget();
    }

    public void a(InterfaceC0026a interfaceC0026a, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i2) {
        Message obtainMessage = this.g.obtainMessage(3004);
        obtainMessage.obj = new Object[]{new b(interfaceC0026a), str, str2, onCompletionListener, Integer.valueOf(i2)};
        obtainMessage.sendToTarget();
    }

    public void b(Message message) {
        Object[] objArr = (Object[]) message.obj;
        InterfaceC0026a interfaceC0026a = (InterfaceC0026a) objArr[0];
        String str = (String) objArr[1];
        MediaPlayer a2 = a(str);
        if (a2 != null) {
            try {
                if (a2.isPlaying()) {
                    a2.stop();
                }
                a2.release();
                b(str);
            } catch (Exception e) {
                e.printStackTrace();
                if (interfaceC0026a != null) {
                    interfaceC0026a.a(e);
                    return;
                }
                return;
            }
        }
        if (interfaceC0026a != null) {
            interfaceC0026a.a(true);
        }
    }

    public void b(InterfaceC0026a interfaceC0026a, String str) {
        Message obtainMessage = this.g.obtainMessage(3005);
        obtainMessage.obj = new Object[]{new b(interfaceC0026a), str};
        obtainMessage.sendToTarget();
    }

    public void b(InterfaceC0026a interfaceC0026a, String str, String str2, MediaPlayer.OnCompletionListener onCompletionListener, int i2) {
        Message obtainMessage = this.g.obtainMessage(3007);
        obtainMessage.obj = new Object[]{new b(interfaceC0026a), str, str2, onCompletionListener, Integer.valueOf(i2)};
        obtainMessage.sendToTarget();
    }

    public void b(String str) {
        if (this.e == null || TextUtils.isEmpty(str) || !this.e.containsKey(str)) {
            return;
        }
        this.e.remove(str);
    }

    public void c(Message message) {
        Object[] objArr = (Object[]) message.obj;
        InterfaceC0026a interfaceC0026a = (InterfaceC0026a) objArr[0];
        try {
            MediaPlayer a2 = a((String) objArr[1]);
            if (a2 != null && a2.isPlaying()) {
                a2.pause();
            }
            if (interfaceC0026a != null) {
                interfaceC0026a.a(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (interfaceC0026a != null) {
                interfaceC0026a.a(e);
            }
        }
    }

    public void d(Message message) {
        Object[] objArr = (Object[]) message.obj;
        InterfaceC0026a interfaceC0026a = (InterfaceC0026a) objArr[0];
        String str = (String) objArr[1];
        String str2 = (String) objArr[2];
        MediaPlayer.OnCompletionListener onCompletionListener = (MediaPlayer.OnCompletionListener) objArr[3];
        int intValue = ((Integer) objArr[4]).intValue();
        try {
            MediaPlayer a2 = a(str);
            if (a2 != null && !a2.isPlaying()) {
                a2.start();
            }
            if (interfaceC0026a != null) {
                interfaceC0026a.a(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.baidu.ar.util.b.d("c exception, recreate player to play");
            c(interfaceC0026a, str, str2, onCompletionListener, intValue);
        }
    }

    public void e(Message message) {
        InterfaceC0026a interfaceC0026a = (InterfaceC0026a) ((Object[]) message.obj)[0];
        this.d = false;
        this.c = 0;
        try {
            if (this.b != null) {
                if (this.b.isPlaying()) {
                    this.b.stop();
                }
                this.b.release();
                this.b = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.e != null) {
            try {
                for (MediaPlayer mediaPlayer : this.e.values()) {
                    if (mediaPlayer != null) {
                        mediaPlayer.release();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.e.clear();
            this.e = null;
        }
        if (interfaceC0026a != null) {
            interfaceC0026a.a(true);
        }
    }
}
