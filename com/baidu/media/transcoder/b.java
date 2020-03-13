package com.baidu.media.transcoder;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.baidu.media.transcoder.a;
import com.baidu.media.transcoder.cyber.MediaTranscoder;
import com.baidu.mobstat.Config;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes6.dex */
public class b implements a {
    private String a;
    private c aMf;
    private a.d aMg;
    private a.InterfaceC0126a aMh;
    private a.b aMi;
    private a.c aMj;
    private a.e aMk;
    private ExecutorService aMl;
    private int c;
    private HashMap<String, String> d;
    private String j;
    private String k;
    private int l;

    public b() {
        this.a = "MediaTranscoderInterface";
        this.aMf = null;
        this.c = 0;
        this.d = new HashMap<>();
        this.aMg = null;
        this.aMh = null;
        this.aMi = null;
        this.aMj = null;
        this.aMk = null;
        this.j = null;
        this.k = null;
        this.l = -1;
        e eVar = new e();
        for (int i = 0; i < 2; i++) {
            this.aMf = eVar.dj(i);
            if (this.aMf.probe() > 0) {
                this.aMl = Executors.newSingleThreadExecutor();
                return;
            }
            this.aMf.release();
            this.aMf = null;
        }
    }

    public b(int i) {
        this.a = "MediaTranscoderInterface";
        this.aMf = null;
        this.c = 0;
        this.d = new HashMap<>();
        this.aMg = null;
        this.aMh = null;
        this.aMi = null;
        this.aMj = null;
        this.aMk = null;
        this.j = null;
        this.k = null;
        this.l = -1;
        this.c = i;
        this.aMf = new e().dj(i);
        this.aMl = Executors.newSingleThreadExecutor();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00d6 A[Catch: all -> 0x0142, TryCatch #0 {, blocks: (B:27:0x00d6, B:28:0x00dd, B:30:0x00f0, B:31:0x00f7, B:32:0x0124, B:34:0x012a, B:56:0x01ad, B:48:0x0183, B:25:0x00d1, B:54:0x01a9, B:55:0x01ac), top: B:66:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f0 A[Catch: all -> 0x0142, TryCatch #0 {, blocks: (B:27:0x00d6, B:28:0x00dd, B:30:0x00f0, B:31:0x00f7, B:32:0x0124, B:34:0x012a, B:56:0x01ad, B:48:0x0183, B:25:0x00d1, B:54:0x01a9, B:55:0x01ac), top: B:66:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012a A[Catch: all -> 0x0142, LOOP:0: B:32:0x0124->B:34:0x012a, LOOP_END, TRY_LEAVE, TryCatch #0 {, blocks: (B:27:0x00d6, B:28:0x00dd, B:30:0x00f0, B:31:0x00f7, B:32:0x0124, B:34:0x012a, B:56:0x01ad, B:48:0x0183, B:25:0x00d1, B:54:0x01a9, B:55:0x01ac), top: B:66:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a() {
        MediaMetadataRetriever mediaMetadataRetriever;
        MediaTranscoder mediaTranscoder = null;
        synchronized (this) {
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(this.j);
                        int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
                        int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                        if (parseInt <= 32000 && this.c == 0 && parseInt2 * parseInt3 < 2073600) {
                            MediaTranscoder mediaTranscoder2 = new MediaTranscoder();
                            try {
                                if (mediaTranscoder2.probe() <= 0) {
                                    mediaTranscoder2.release();
                                } else {
                                    mediaTranscoder = mediaTranscoder2;
                                }
                                this.c = 1;
                            } catch (Exception e) {
                                e = e;
                                mediaTranscoder = mediaTranscoder2;
                                e.printStackTrace();
                                if (mediaMetadataRetriever != null) {
                                    mediaMetadataRetriever.release();
                                }
                                if (mediaTranscoder != null) {
                                }
                                this.aMf.setDataSource(this.j);
                                this.aMf.setOutputFile(this.k);
                                if (this.l != -1) {
                                }
                                this.aMf.setOnCompletionListener(this.aMh);
                                this.aMf.setOnErrorListener(this.aMi);
                                this.aMf.setOnPreparedListener(this.aMg);
                                this.aMf.setOnInfoListener(this.aMj);
                                this.aMf.setOnTerminalListener(this.aMk);
                                while (r2.hasNext()) {
                                }
                                this.aMf.prepareAsync();
                            }
                        }
                        if (this.c == 1) {
                            String str = this.d.get("s");
                            if (!TextUtils.isEmpty(str)) {
                                String[] split = str.split(Config.EVENT_HEAT_X);
                                int parseInt4 = (Integer.parseInt(split[0]) / 2) * 2;
                                int parseInt5 = (Integer.parseInt(split[1]) / 2) * 2;
                                this.d.put("s", parseInt4 + Config.EVENT_HEAT_X + parseInt5);
                                if (parseInt4 * parseInt5 <= 921600) {
                                    this.d.put("crf", Constants.VIA_REPORT_TYPE_WPA_STATE);
                                    this.d.put("maxrate", "5000K");
                                    this.d.put("bufsize", "10000k");
                                    this.d.put("preset", "superfast");
                                } else if (parseInt4 * parseInt5 > 921600 && parseInt5 * parseInt4 <= 1393200) {
                                    this.d.put("crf", Constants.VIA_REPORT_TYPE_WPA_STATE);
                                    this.d.put("maxrate", "5000K");
                                    this.d.put("bufsize", "10000k");
                                    this.d.put("preset", "veryfast");
                                }
                            }
                        } else {
                            this.d.put("duration", "" + parseInt);
                        }
                        if (mediaMetadataRetriever != null) {
                            mediaMetadataRetriever.release();
                        }
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                mediaMetadataRetriever = null;
            } catch (Throwable th2) {
                th = th2;
                mediaMetadataRetriever = null;
            }
            if (mediaTranscoder != null) {
                this.aMf.release();
                this.aMf = mediaTranscoder;
            }
            this.aMf.setDataSource(this.j);
            this.aMf.setOutputFile(this.k);
            if (this.l != -1) {
                this.aMf.setNativeLogLevel(this.l);
            }
            this.aMf.setOnCompletionListener(this.aMh);
            this.aMf.setOnErrorListener(this.aMi);
            this.aMf.setOnPreparedListener(this.aMg);
            this.aMf.setOnInfoListener(this.aMj);
            this.aMf.setOnTerminalListener(this.aMk);
            for (Map.Entry<String, String> entry : this.d.entrySet()) {
                this.aMf.setOption(entry.getKey(), entry.getValue());
            }
            this.aMf.prepareAsync();
        }
    }

    @Override // com.baidu.media.transcoder.a
    public synchronized void prepareAsync() {
        if (this.aMf != null) {
            this.aMl.submit(new Runnable() { // from class: com.baidu.media.transcoder.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.a();
                }
            });
        }
    }

    @Override // com.baidu.media.transcoder.a
    public int probe() {
        if (this.aMf == null) {
            return 0;
        }
        return this.aMf.probe();
    }

    @Override // com.baidu.media.transcoder.a
    public synchronized void release() {
        if (this.aMf != null) {
            this.aMf.release();
            this.aMf = null;
        }
    }

    @Override // com.baidu.media.transcoder.a
    public void setDataSource(String str) {
        this.j = str;
    }

    @Override // com.baidu.media.transcoder.a
    public void setNativeLogLevel(int i) {
        this.l = i;
    }

    public void setOnCompletionListener(a.InterfaceC0126a interfaceC0126a) {
        this.aMh = interfaceC0126a;
    }

    public void setOnErrorListener(a.b bVar) {
        this.aMi = bVar;
    }

    public void setOnInfoListener(a.c cVar) {
        this.aMj = cVar;
    }

    public void setOnPreparedListener(a.d dVar) {
        this.aMg = dVar;
    }

    public void setOnTerminalListener(a.e eVar) {
        this.aMk = eVar;
    }

    @Override // com.baidu.media.transcoder.a
    public synchronized void setOption(String str, String str2) {
        this.d.put(str, str2);
    }

    @Override // com.baidu.media.transcoder.a
    public void setOutputFile(String str) {
        this.k = str;
    }

    @Override // com.baidu.media.transcoder.a
    public synchronized void start() {
        if (this.aMf != null) {
            this.aMf.start();
        }
    }

    @Override // com.baidu.media.transcoder.a
    public synchronized void stop() {
        if (this.aMf != null) {
            this.aMf.stop();
        }
    }
}
