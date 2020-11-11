package com.baidu.rtc.a;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.util.Log;
import com.baidu.rtc.ndk.AlaNDKPlayerAdapter;
import com.baidu.rtc.ndk.AudioProcessModule;
import com.baidu.rtc.utils.AudioRouteMonitor;
import com.baidu.rtc.utils.d;
import java.nio.ByteBuffer;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes11.dex */
public class a {
    private static final String TAG = a.class.getSimpleName();
    private AlaNDKPlayerAdapter coA;
    private AudioManager mAudioManager;
    private Context mContext;
    private boolean mRunOpenSLES;
    private AudioTrack mAudioTrack = null;
    private AudioRecord mAudioRecord = null;
    private C0324a coy = new C0324a();
    private C0324a coz = new C0324a();
    private AudioRouteMonitor coB = null;
    private boolean coC = false;

    public a(Context context, long j) {
        this.mContext = null;
        this.coA = null;
        this.mAudioManager = null;
        this.mRunOpenSLES = false;
        this.mContext = context;
        this.coA = new AlaNDKPlayerAdapter();
        this.coA.setNativeObject(j);
        try {
            this.mAudioManager = (AudioManager) this.mContext.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        } catch (Exception e) {
            e.printStackTrace();
        }
        d.initConfig(context);
        this.mRunOpenSLES = d.useOpenSLES();
    }

    public boolean Z(int i, int i2) {
        if (this.coy.flags == 1) {
            return true;
        }
        this.coy.sampleRate = i;
        this.coy.channels = i2;
        this.coy.flags = 1;
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, 2);
        try {
        } catch (IllegalArgumentException e) {
            this.mAudioTrack = null;
            e.printStackTrace();
        } catch (Exception e2) {
            this.mAudioTrack = null;
            e2.printStackTrace();
        }
        if (d.useOpenSLES()) {
            int i3 = i2 != 12 ? 1 : 2;
            AudioProcessModule.sharedInstance().updateSystemInfo(Build.VERSION.SDK_INT, Build.MODEL);
            this.coA.setWebRtcHandle(AudioProcessModule.sharedInstance().getContext());
            if (AudioProcessModule.sharedInstance().createAudioPlayer(d.OUTPUT_SAMPLE_RATE, i3, d.OUTPUT_FRAMES_PER_BUFFER) != 0) {
                Log.e(TAG, "createAudioPlayer failed");
            }
            if (AudioProcessModule.sharedInstance().setRenderBuffer(this.coy.coL, 1.2f) != 0) {
                Log.e(TAG, "setRenderBuffer failed");
            }
            AudioProcessModule.sharedInstance().setRenderCallback(new AudioProcessModule.RenderCallback() { // from class: com.baidu.rtc.a.a.1
                @Override // com.baidu.rtc.ndk.AudioProcessModule.RenderCallback
                public void onRenderData(int i4) {
                    a.this.coy.coE = System.currentTimeMillis();
                }
            });
            if (AudioProcessModule.sharedInstance().audioPlayerStart() != 0) {
                Log.e(TAG, "audioPlayerStart failed");
                return true;
            }
            return true;
        }
        AudioProcessModule.sharedInstance().updateSystemInfo(Build.VERSION.SDK_INT, Build.MODEL);
        this.coA.setWebRtcHandle(AudioProcessModule.sharedInstance().getContext());
        if (AudioProcessModule.sharedInstance().setRenderBuffer(this.coy.coL, 1.2f) != 0) {
            Log.e(TAG, "setRenderBuffer failed");
        }
        this.coy.coG = (i / 100) * 2;
        this.mAudioTrack = new AudioTrack(0, i, i2, 2, minBufferSize, 1);
        this.mAudioTrack.play();
        return this.mAudioTrack != null;
    }

    public boolean aa(int i, int i2) {
        if (this.coz.flags == 1) {
            return true;
        }
        this.coz.sampleRate = i;
        this.coz.channels = i2;
        this.coz.flags = 1;
        int minBufferSize = AudioRecord.getMinBufferSize(i, i2, 2);
        if (minBufferSize < i) {
            minBufferSize = i;
        }
        aeC();
        if (this.mAudioManager != null) {
            try {
                this.mAudioManager.setSpeakerphoneOn(!this.mAudioManager.isWiredHeadsetOn());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (d.initConfig(this.mContext) < 0) {
            Log.e(TAG, "StreamConfig.initConfig failed");
        }
        if (this.mRunOpenSLES) {
            this.mAudioRecord = null;
            int i3 = i2 == 12 ? 2 : 1;
            int i4 = d.OUTPUT_SAMPLE_RATE / 100;
            if (AudioProcessModule.sharedInstance().createAudioProcessModule(d.OUTPUT_SAMPLE_RATE, i, i3, i3, 1, 1, 1) != 0) {
                Log.e(TAG, "createAudioProcessModule failed");
            }
            AudioProcessModule.sharedInstance().updateSystemInfo(Build.VERSION.SDK_INT, Build.MODEL);
            if (AudioProcessModule.sharedInstance().createAudioRecorder(i, i3, i4) != 0) {
                Log.e(TAG, "createAudioRecorder failed");
            }
            AudioProcessModule.sharedInstance().setCaptureCallback(new AudioProcessModule.CaptureCallback() { // from class: com.baidu.rtc.a.a.2
                @Override // com.baidu.rtc.ndk.AudioProcessModule.CaptureCallback
                public void onCaptureData(int i5) {
                    a.this.coz.coE = System.currentTimeMillis();
                }
            });
            if (AudioProcessModule.sharedInstance().audioRecorderStart() != 0) {
                Log.e(TAG, "audioRecorderStart failed");
            }
            return true;
        }
        try {
            this.mAudioRecord = new AudioRecord(7, i, i2, 2, minBufferSize);
            this.coz.coG = (i / 100) * 2;
            int i5 = i2 == 12 ? 2 : 1;
            AudioProcessModule.sharedInstance().createAudioProcessModule(d.OUTPUT_SAMPLE_RATE, i, i5, i5, 0, 1, 1);
            AudioProcessModule.sharedInstance().setCaptureBuffer(this.coz.coL, 1.3f);
            this.mAudioRecord.startRecording();
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            this.mAudioRecord = null;
        } catch (Exception e3) {
            e3.printStackTrace();
            this.mAudioRecord = null;
        }
        if (this.mRunOpenSLES || this.mAudioRecord == null || this.mAudioRecord.getState() != 0) {
            return this.mAudioRecord != null;
        }
        this.mAudioRecord = null;
        return false;
    }

    public void stopAudioRecord() {
        if (this.mAudioRecord != null) {
            try {
                this.mAudioRecord.stop();
                this.mAudioRecord.release();
                this.coz.coK = null;
                this.coz.coJ = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mAudioRecord = null;
            this.coz.flags = 2;
        }
        if (d.useOpenSLES() && AudioProcessModule.sharedInstance().audioRecorderStop() != 0) {
            Log.e(TAG, "OpenSLES audio recorder stop failed");
        }
    }

    public void stopAudioPlayer() {
        if (this.mAudioTrack != null) {
            try {
                this.mAudioTrack.stop();
                this.mAudioTrack.release();
                this.coz.coK = null;
                this.coz.coJ = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.mAudioTrack = null;
            this.coy.flags = 2;
        }
        if (d.useOpenSLES() && AudioProcessModule.sharedInstance().audioPlayerStop() != 0) {
            Log.e(TAG, "OpenSLES audio player stop failed");
        }
    }

    public void destroy() {
        aeB();
        this.mContext = null;
        AudioProcessModule.sharedInstance().destroyAudioProcessModule();
        AudioProcessModule.sharedInstance().setCaptureCallback(null);
        AudioProcessModule.sharedInstance().setRenderCallback(null);
    }

    public void mute() {
        this.coy.mute = 1;
        this.coz.mute = 1;
        if (d.useOpenSLES()) {
            if (AudioProcessModule.sharedInstance().audioRecorderSetOpt(3) != 0) {
                Log.e(TAG, "mute rec failed");
            }
            if (AudioProcessModule.sharedInstance().audioPlayerSetOpt(3) != 0) {
                Log.e(TAG, "mute ply failed");
            }
        }
    }

    public void unMute() {
        this.coy.mute = 2;
        this.coz.mute = 2;
        if (d.useOpenSLES()) {
            if (AudioProcessModule.sharedInstance().audioRecorderSetOpt(4) != 0) {
                Log.e(TAG, "unMute rec failed");
            }
            if (AudioProcessModule.sharedInstance().audioPlayerSetOpt(4) != 0) {
                Log.e(TAG, "mute ply failed");
            }
        }
    }

    public void pause() {
        this.coy.coF = 1;
        this.coz.coF = 1;
        if (d.useOpenSLES()) {
            if (AudioProcessModule.sharedInstance().audioRecorderSetOpt(1) != 0) {
                Log.e(TAG, "pause rec failed");
            }
            if (AudioProcessModule.sharedInstance().audioPlayerSetOpt(1) != 0) {
                Log.e(TAG, "pause ply failed");
            }
        }
    }

    public void resume() {
        this.coy.coF = 2;
        this.coz.coF = 2;
        if (d.useOpenSLES()) {
            if (AudioProcessModule.sharedInstance().audioRecorderSetOpt(2) != 0) {
                Log.e(TAG, "resume failed");
            }
            if (AudioProcessModule.sharedInstance().audioPlayerSetOpt(2) != 0) {
                Log.e(TAG, "resume ply failed");
            }
        }
    }

    public byte[] aeA() {
        boolean z = true;
        if (d.useOpenSLES() || this.mAudioRecord == null || this.coz.coF == 1) {
            return null;
        }
        do {
            try {
                int read = this.mAudioRecord.read(this.coz.coL.array(), 0, this.coz.coG);
                if (read != this.coz.coG) {
                    Log.e(TAG, "readDataRTC read data error. length is " + read);
                    return null;
                }
                if (this.coz.mute == 1) {
                    byte[] array = this.coz.coL.array();
                    for (int i = 0; i < array.length; i++) {
                        array[i] = 0;
                    }
                }
                this.coz.coH[0] = 0;
                this.coz.coI[0] = this.coz.coG;
                int updateCaptureBuffer = AudioProcessModule.sharedInstance().updateCaptureBuffer(this.coz.coH, this.coz.coI);
                if (updateCaptureBuffer != 0) {
                    Log.e(TAG, "AudioProcessModule.updateCaptureBuffer failed " + updateCaptureBuffer);
                }
                if (updateCaptureBuffer != 0 || this.coz.coI[0] <= 0) {
                    z = false;
                    break;
                }
                this.coz.coJ.write(this.coz.coL.array(), 0, this.coz.coI[0]);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } while (this.coz.coJ.size() <= 2048);
        this.coz.coJ.read(this.coz.coK, 0, 2048);
        this.coz.coJ.delete(2048);
        if (z) {
            return this.coz.coK;
        }
        return null;
    }

    public void writeData(byte[] bArr, int i, int i2) {
        if (bArr != null && bArr.length != 0 && !d.useOpenSLES() && this.mAudioTrack != null && this.coy.coF != 1 && this.mAudioTrack.getState() != 0) {
            if (this.coy.mute == 1) {
                for (int i3 = 0; i3 < i2; i3++) {
                    bArr[i + i3] = 0;
                }
            }
            try {
                int playState = this.mAudioTrack.getPlayState();
                if (playState != 3) {
                    this.mAudioTrack.play();
                    playState = this.mAudioTrack.getPlayState();
                }
                if (playState == 3) {
                    try {
                        this.coy.coL.rewind();
                        this.coy.coL.put(bArr, i, i2);
                        this.coy.coH[0] = 0;
                        this.coy.coI[0] = i2;
                        if (AudioProcessModule.sharedInstance().updateRenderBuffer(this.coy.coH, this.coy.coI) != 0) {
                            Log.e(TAG, "AudioProcessModule.updateRenderBuffer failed");
                        }
                        this.mAudioTrack.write(this.coy.coL.array(), 0, i2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private void aeB() {
        try {
            this.coB.uninit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void aeC() {
        try {
            if (this.mContext != null) {
                this.coB = new AudioRouteMonitor(new AudioRouteMonitor.a() { // from class: com.baidu.rtc.a.a.3
                    @Override // com.baidu.rtc.utils.AudioRouteMonitor.a
                    public void hi(int i) {
                        a.this.m(a.this.mContext, i == 0);
                    }

                    @Override // com.baidu.rtc.utils.AudioRouteMonitor.a
                    public void hj(int i) {
                        a.this.l(a.this.mContext, i != 0);
                        if (i > 0) {
                            a.this.coC = true;
                        } else {
                            a.this.coC = false;
                        }
                    }
                });
                this.coB.init(this.mContext);
                try {
                    if (this.mAudioManager.isBluetoothA2dpOn()) {
                        this.mAudioManager.setBluetoothScoOn(true);
                        this.mAudioManager.startBluetoothSco();
                        this.coC = true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Context context, boolean z) {
        if (this.mAudioManager != null) {
            try {
                this.mAudioManager.setBluetoothScoOn(z);
                if (z) {
                    this.mAudioManager.startBluetoothSco();
                } else {
                    this.mAudioManager.stopBluetoothSco();
                    this.mAudioManager.setSpeakerphoneOn(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Context context, boolean z) {
        if (this.mAudioManager != null) {
            try {
                if (this.coC) {
                    l(this.mContext, !z);
                }
                this.mAudioManager.setSpeakerphoneOn(z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: com.baidu.rtc.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    static class C0324a {
        int channels;
        public long coE;
        int sampleRate;
        int flags = 0;
        int mute = 2;
        int coF = 2;
        int coG = 256;
        int[] coH = new int[1];
        int[] coI = new int[1];
        com.baidu.rtc.utils.a coJ = new com.baidu.rtc.utils.a();
        byte[] coK = new byte[2048];
        ByteBuffer coL = ByteBuffer.allocateDirect(4096);

        C0324a() {
        }
    }
}
