package com.baidu.searchbox.ugc.transcoder;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.pyramid.runtime.service.c;
import com.baidu.searchbox.ugc.transcoder.IMediaTranscoder;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes18.dex */
public class TranscoderManager {
    public static final int MODE_AUTO = 2;
    public static final int MODE_HW = 0;
    public static final int MODE_SW = 1;
    private static final String TAG = "TranscoderManager";
    private String mDataSource;
    private OnCompletionListener mOnCompletionListener;
    private OnErrorListener mOnErrorListener;
    private OnInfoListener mOnInfoListener;
    private OnPreparedListener mOnPreparedListener;
    private OnTerminalListener mOnTerminalListener;
    private String mOutputFile;
    private long mStartTime;
    private IMediaTranscoder mTranscoder;
    private int mTranscoderMode = 2;
    private volatile int mCurrMode = 2;
    private Map<String, String> mOptionMap = new LinkedHashMap();

    /* loaded from: classes18.dex */
    public interface OnCompletionListener {
        void onCompletion();
    }

    /* loaded from: classes18.dex */
    public interface OnErrorListener {
        boolean onError(int i, int i2);
    }

    /* loaded from: classes18.dex */
    public interface OnInfoListener {
        boolean onInfo(int i, int i2, Object obj);
    }

    /* loaded from: classes18.dex */
    public interface OnPreparedListener {
        void onPrepared();
    }

    /* loaded from: classes18.dex */
    public interface OnTerminalListener {
        void onTerminal();
    }

    public void setTranscoderMode(int i) {
        this.mTranscoderMode = i;
        this.mCurrMode = i;
    }

    public String getSDKVersion() {
        if (this.mTranscoder != null) {
            this.mTranscoder.getSDKVersion();
            return null;
        }
        return null;
    }

    public int probe() {
        if (this.mTranscoder != null) {
            this.mTranscoder.probe();
            return 0;
        }
        return 0;
    }

    public int getMode() {
        if (this.mTranscoder != null) {
            this.mTranscoder.getMode();
            return 0;
        }
        return 0;
    }

    public void setDataSource(String str) {
        this.mDataSource = str;
    }

    public void setOutputFile(String str) {
        this.mOutputFile = str;
    }

    public void setOption(String str, String str2) {
        this.mOptionMap.put(str, str2);
    }

    public void setOption(String str) {
        if (this.mTranscoder != null) {
            this.mTranscoder.setOption(str);
        }
    }

    public void prepareAsync() {
        this.mStartTime = System.currentTimeMillis();
        switch (this.mCurrMode) {
            case 0:
                if (!supportHw()) {
                    if (this.mOnErrorListener != null) {
                        this.mOnErrorListener.onError(0, 0);
                        return;
                    }
                    return;
                }
                this.mCurrMode = 0;
                this.mTranscoder = (IMediaTranscoder) c.a(IMediaTranscoder.SERVICE_REFERENCE);
                if (this.mTranscoder != null) {
                    this.mTranscoder.setTranscoderMode(this.mCurrMode);
                    setData();
                    this.mTranscoder.prepareAsync();
                    return;
                }
                return;
            case 1:
                this.mCurrMode = 1;
                this.mTranscoder = (IMediaTranscoder) c.a(IMediaTranscoder.SERVICE_REFERENCE);
                if (this.mTranscoder != null) {
                    this.mTranscoder.setTranscoderMode(this.mCurrMode);
                    setData();
                    this.mTranscoder.prepareAsync();
                    return;
                }
                return;
            case 2:
                if (supportHw()) {
                    this.mCurrMode = 0;
                } else {
                    this.mCurrMode = 1;
                }
                prepareAsync();
                return;
            default:
                return;
        }
    }

    private boolean supportHw() {
        return Build.VERSION.SDK_INT >= 18;
    }

    private void setData() {
        this.mTranscoder.setOnPreparedListener(new IMediaTranscoder.OnPreparedListener() { // from class: com.baidu.searchbox.ugc.transcoder.TranscoderManager.1
            @Override // com.baidu.searchbox.ugc.transcoder.IMediaTranscoder.OnPreparedListener
            public void onPrepared(IMediaTranscoder iMediaTranscoder) {
                if (TranscoderManager.this.mTranscoderMode != 2 || TranscoderManager.this.mCurrMode != 1) {
                    if (TranscoderManager.this.mOnPreparedListener != null) {
                        TranscoderManager.this.mOnPreparedListener.onPrepared();
                        return;
                    }
                    return;
                }
                TranscoderManager.this.start();
            }
        });
        this.mTranscoder.setOnErrorListener(new IMediaTranscoder.OnErrorListener() { // from class: com.baidu.searchbox.ugc.transcoder.TranscoderManager.2
            @Override // com.baidu.searchbox.ugc.transcoder.IMediaTranscoder.OnErrorListener
            public boolean onError(IMediaTranscoder iMediaTranscoder, int i, int i2) {
                if (!TextUtils.isEmpty(TranscoderManager.this.mOutputFile)) {
                    File file = new File(TranscoderManager.this.mOutputFile);
                    if (file.exists()) {
                        file.delete();
                    }
                }
                if (TranscoderManager.this.mTranscoderMode != 2 || TranscoderManager.this.mCurrMode != 0) {
                    if (TranscoderManager.this.mOnErrorListener != null) {
                        TranscoderManager.this.mOnErrorListener.onError(i, i2);
                    }
                } else {
                    try {
                        TranscoderManager.this.mTranscoder.release();
                        TranscoderManager.this.mCurrMode = 1;
                        TranscoderManager.this.prepareAsync();
                    } catch (Throwable th) {
                        if (TranscoderManager.this.mOnErrorListener != null) {
                            TranscoderManager.this.mOnErrorListener.onError(1, i2);
                        }
                    }
                }
                return true;
            }
        });
        this.mTranscoder.setOnCompletionListener(new IMediaTranscoder.OnCompletionListener() { // from class: com.baidu.searchbox.ugc.transcoder.TranscoderManager.3
            @Override // com.baidu.searchbox.ugc.transcoder.IMediaTranscoder.OnCompletionListener
            public void onCompletion(IMediaTranscoder iMediaTranscoder) {
                if (TranscoderManager.this.mOnCompletionListener != null) {
                    TranscoderManager.this.mOnCompletionListener.onCompletion();
                }
            }
        });
        this.mTranscoder.setOnInfoListener(new IMediaTranscoder.OnInfoListener() { // from class: com.baidu.searchbox.ugc.transcoder.TranscoderManager.4
            @Override // com.baidu.searchbox.ugc.transcoder.IMediaTranscoder.OnInfoListener
            public boolean onInfo(IMediaTranscoder iMediaTranscoder, int i, int i2, Object obj) {
                if (TranscoderManager.this.mOnInfoListener != null) {
                    return TranscoderManager.this.mOnInfoListener.onInfo(i, i2, obj);
                }
                return true;
            }
        });
        this.mTranscoder.setOnTerminalListener(new IMediaTranscoder.OnTerminalListener() { // from class: com.baidu.searchbox.ugc.transcoder.TranscoderManager.5
            @Override // com.baidu.searchbox.ugc.transcoder.IMediaTranscoder.OnTerminalListener
            public void onTerminal(IMediaTranscoder iMediaTranscoder) {
                if (TranscoderManager.this.mOnTerminalListener != null) {
                    TranscoderManager.this.mOnTerminalListener.onTerminal();
                }
            }
        });
        this.mTranscoder.setDataSource(this.mDataSource);
        this.mTranscoder.setOutputFile(this.mOutputFile);
        for (Map.Entry<String, String> entry : this.mOptionMap.entrySet()) {
            this.mTranscoder.setOption(entry.getKey(), entry.getValue());
        }
    }

    public void start() {
        if (this.mTranscoder != null) {
            this.mTranscoder.start();
        }
    }

    public void pause() {
        if (this.mTranscoder != null) {
            this.mTranscoder.pause();
        }
    }

    public void stop() {
        if (this.mTranscoder != null) {
            this.mTranscoder.stop();
        }
    }

    public void reset() {
        if (this.mTranscoder != null) {
            this.mTranscoder.reset();
        }
    }

    public void release() {
        if (this.mTranscoder != null) {
            this.mTranscoder.release();
        }
    }

    public void setOnPreparedListener(OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
    }

    public void setOnErrorListener(OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnCompletionListener(OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnInfoListener(OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnTerminalListener(OnTerminalListener onTerminalListener) {
        this.mOnTerminalListener = onTerminalListener;
    }
}
