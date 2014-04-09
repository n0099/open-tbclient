package com.baidu.tbadk.core.voice.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import com.baidu.location.LocationClientOption;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class MediaService extends Service implements MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener {
    private int b = 0;
    private long c = 0;
    private Handler d = new Handler();
    private int e = 0;
    private Voice f = null;
    private String g = new String();
    private Runnable h = new a(this);
    private Runnable i = new b(this);
    private d j = null;
    private c k = f.b();
    long a = 0;

    public static void a(Context context, String str, int i, int i2) {
        Intent intent = new Intent();
        intent.setAction("preparePlayer");
        Voice voice = new Voice();
        voice.a(str);
        voice.a(i);
        intent.putExtra("com.baidu.voices", voice);
        intent.putExtra("com.baidu.msg.curr_time", i2);
        a(context, intent);
    }

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("playVoice");
        a(context, intent);
    }

    public static void b(Context context) {
        Intent intent = new Intent();
        intent.setAction("stopVoice");
        a(context, intent);
    }

    public static void a(Context context, Intent intent) {
        if (context != null) {
            if (intent == null) {
                intent = new Intent();
            }
            intent.setClass(context, MediaService.class);
            context.startService(intent);
        }
    }

    public static void c(Context context) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, MediaService.class);
            try {
                context.stopService(intent);
            } catch (Exception e) {
            }
        }
    }

    public static void a(Context context, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.playPrepared");
        intentFilter.addAction("com.baidu.isPlaying");
        intentFilter.addAction("com.baidu.isStoped");
        intentFilter.addAction("com.baidu.playElapsedTime");
        intentFilter.addAction("com.baidu.recognize");
        LocalBroadcastManager.getInstance(context).registerReceiver(broadcastReceiver, intentFilter);
    }

    public static void b(Context context, BroadcastReceiver broadcastReceiver) {
        if (context != null && broadcastReceiver != null) {
            try {
                LocalBroadcastManager.getInstance(context).unregisterReceiver(broadcastReceiver);
            } catch (Exception e) {
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.removeCallbacks(this.h);
        }
        this.d = null;
        this.f = null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i) {
        super.onStart(intent, i);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.onStartCommand(intent, i, i2);
        }
        String action = intent.getAction();
        if (action == null || action.length() == 0) {
            return super.onStartCommand(intent, i, i2);
        }
        try {
            Method declaredMethod = getClass().getDeclaredMethod(action, Intent.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(this, intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, i, i2);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        int i;
        Intent intent = new Intent("com.baidu.playPrepared");
        intent.setFlags(1073741824);
        intent.putExtra("com.baidu.playPrepared_err_code", -1);
        if (this.f == null) {
            i = 0;
        } else {
            long a = this.f.a();
            if (a == 0 && (this.k instanceof f)) {
                a = ((f) this.k).getDuration() / LocationClientOption.MIN_SCAN_SPAN;
            }
            i = (int) a;
        }
        long j = i * LocationClientOption.MIN_SCAN_SPAN;
        long duration = this.k instanceof f ? ((f) this.k).getDuration() : 0L;
        if (duration - j > 1000 || duration < j) {
            duration = j;
        }
        intent.putExtra("com.baidu.msg.durationTime", i);
        intent.putExtra("com.baidu.msg.durationTime2", duration);
        if (this.a > 0) {
            long j2 = this.a;
        }
        this.a = 0L;
        sendBroadcast(intent);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }
}
