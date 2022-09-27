package com.baidu.rtc;

import android.os.Environment;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.rtc.RTCAudioSamples;
import com.baidu.rtc.RtcAudioDumper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
/* loaded from: classes2.dex */
public class RtcAudioDumper implements RTCAudioSamples.RTCSamplesReadyCallback, RTCAudioSamples.RTCRemoteSamplesReadyCallback {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long MAX_FILE_SIZE_IN_BYTES = 58348800;
    public static final String TAG = "RtcRemoteAudioDumper";
    public transient /* synthetic */ FieldHolder $fh;
    public final ExecutorService executor;
    public long fileSizeInBytes;
    public boolean isRunning;
    public final Object lock;
    @Nullable
    public OutputStream rawAudioFileOutputStream;

    public RtcAudioDumper(ExecutorService executorService) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {executorService};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.lock = new Object();
        Log.d(TAG, "remote audio dumper created");
        this.executor = executorService;
    }

    private void dumpAudioSamples(final RTCAudioSamples rTCAudioSamples) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, this, rTCAudioSamples) == null) {
            if (rTCAudioSamples.getAudioFormat() != 2) {
                Log.e(TAG, "Invalid audio format");
                return;
            }
            synchronized (this.lock) {
                if (this.isRunning) {
                    if (this.rawAudioFileOutputStream == null) {
                        openRawAudioOutputFile(rTCAudioSamples.getSampleRate(), rTCAudioSamples.getChannelCount());
                        this.fileSizeInBytes = 0L;
                    }
                    this.executor.execute(new Runnable() { // from class: com.baidu.tieba.kf1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        @Override // java.lang.Runnable
                        public final void run() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                                RtcAudioDumper.this.a(rTCAudioSamples);
                            }
                        }
                    });
                }
            }
        }
    }

    private boolean isExternalStorageWritable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) ? "mounted".equals(Environment.getExternalStorageState()) : invokeV.booleanValue;
    }

    private void openRawAudioOutputFile(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65539, this, i, i2) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStorageDirectory().getPath());
            sb.append(File.separator);
            sb.append("audio_16bits_");
            sb.append(String.valueOf(i));
            sb.append("Hz");
            sb.append(i2 == 1 ? "_mono_" : "_stereo_");
            sb.append(System.currentTimeMillis());
            sb.append(".pcm");
            String sb2 = sb.toString();
            try {
                this.rawAudioFileOutputStream = new FileOutputStream(new File(sb2));
            } catch (FileNotFoundException e) {
                Log.e(TAG, "Failed to open audio output file: " + e.getMessage());
            }
            Log.d(TAG, "Opened file for recording: " + sb2);
        }
    }

    public /* synthetic */ void a(RTCAudioSamples rTCAudioSamples) {
        OutputStream outputStream = this.rawAudioFileOutputStream;
        if (outputStream != null) {
            try {
                if (this.fileSizeInBytes < MAX_FILE_SIZE_IN_BYTES) {
                    outputStream.write(rTCAudioSamples.getData());
                    this.fileSizeInBytes += rTCAudioSamples.getData().length;
                }
            } catch (IOException e) {
                Log.e(TAG, "Failed to write audio to file: " + e.getMessage());
            }
        }
    }

    @Override // com.baidu.rtc.RTCAudioSamples.RTCSamplesReadyCallback
    public void onRtcAudioRecordSamplesReady(RTCAudioSamples rTCAudioSamples) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rTCAudioSamples) == null) {
            dumpAudioSamples(rTCAudioSamples);
        }
    }

    @Override // com.baidu.rtc.RTCAudioSamples.RTCRemoteSamplesReadyCallback
    public void onRtcAudioRemoteSamplesReady(RTCAudioSamples rTCAudioSamples) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, rTCAudioSamples) == null) {
            dumpAudioSamples(rTCAudioSamples);
        }
    }

    public boolean start() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Log.d(TAG, "remote audio dumper start");
            if (!isExternalStorageWritable()) {
                Log.e(TAG, "Writing to external media is not possible");
                return false;
            }
            synchronized (this.lock) {
                this.isRunning = true;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void stop() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Log.d(TAG, "remote audio dumper stop");
            synchronized (this.lock) {
                this.isRunning = false;
                if (this.rawAudioFileOutputStream != null) {
                    try {
                        this.rawAudioFileOutputStream.close();
                    } catch (IOException e) {
                        Log.e(TAG, "Failed to close file with saved input audio: " + e);
                    }
                    this.rawAudioFileOutputStream = null;
                }
                this.fileSizeInBytes = 0L;
            }
        }
    }
}
