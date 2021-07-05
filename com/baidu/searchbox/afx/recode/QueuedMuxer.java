package com.baidu.searchbox.afx.recode;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class QueuedMuxer {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BUFFER_SIZE = 65536;
    public static final String TAG = "QueuedMuxer";
    public transient /* synthetic */ FieldHolder $fh;
    public ByteBuffer mByteBuffer;
    public final MediaMuxer mMuxer;
    public final List<SampleInfo> mSampleInfoList;
    public boolean mStarted;
    public MediaFormat mVideoFormat;
    public int mVideoTrackIndex;

    /* renamed from: com.baidu.searchbox.afx.recode.QueuedMuxer$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$afx$recode$QueuedMuxer$SampleType;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1065976797, "Lcom/baidu/searchbox/afx/recode/QueuedMuxer$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1065976797, "Lcom/baidu/searchbox/afx/recode/QueuedMuxer$1;");
                    return;
                }
            }
            int[] iArr = new int[SampleType.values().length];
            $SwitchMap$com$baidu$searchbox$afx$recode$QueuedMuxer$SampleType = iArr;
            try {
                iArr[SampleType.VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class SampleInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int mFlags;
        public final long mPresentationTimeUs;
        public final SampleType mSampleType;
        public final int mSize;

        public /* synthetic */ SampleInfo(SampleType sampleType, int i2, MediaCodec.BufferInfo bufferInfo, AnonymousClass1 anonymousClass1) {
            this(sampleType, i2, bufferInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void writeToBufferInfo(MediaCodec.BufferInfo bufferInfo, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(AdIconUtil.AD_TEXT_ID, this, bufferInfo, i2) == null) {
                bufferInfo.set(i2, this.mSize, this.mPresentationTimeUs, this.mFlags);
            }
        }

        public SampleInfo(SampleType sampleType, int i2, MediaCodec.BufferInfo bufferInfo) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sampleType, Integer.valueOf(i2), bufferInfo};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mSampleType = sampleType;
            this.mSize = i2;
            this.mPresentationTimeUs = bufferInfo.presentationTimeUs;
            this.mFlags = bufferInfo.flags;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class SampleType {
        public static final /* synthetic */ SampleType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final SampleType VIDEO;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1109446724, "Lcom/baidu/searchbox/afx/recode/QueuedMuxer$SampleType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1109446724, "Lcom/baidu/searchbox/afx/recode/QueuedMuxer$SampleType;");
                    return;
                }
            }
            SampleType sampleType = new SampleType(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO, 0);
            VIDEO = sampleType;
            $VALUES = new SampleType[]{sampleType};
        }

        public SampleType(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static SampleType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (SampleType) Enum.valueOf(SampleType.class, str) : (SampleType) invokeL.objValue;
        }

        public static SampleType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (SampleType[]) $VALUES.clone() : (SampleType[]) invokeV.objValue;
        }
    }

    public QueuedMuxer(MediaMuxer mediaMuxer) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mediaMuxer};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mMuxer = mediaMuxer;
        this.mSampleInfoList = new ArrayList();
    }

    private int getTrackIndexForSampleType(SampleType sampleType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, sampleType)) == null) {
            if (AnonymousClass1.$SwitchMap$com$baidu$searchbox$afx$recode$QueuedMuxer$SampleType[sampleType.ordinal()] == 1) {
                return this.mVideoTrackIndex;
            }
            throw new AssertionError();
        }
        return invokeL.intValue;
    }

    private void onSetOutputFormat() {
        MediaFormat mediaFormat;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65538, this) == null) || (mediaFormat = this.mVideoFormat) == null) {
            return;
        }
        this.mVideoTrackIndex = this.mMuxer.addTrack(mediaFormat);
        this.mMuxer.start();
        this.mStarted = true;
        int i2 = 0;
        if (this.mByteBuffer == null) {
            this.mByteBuffer = ByteBuffer.allocate(0);
        }
        this.mByteBuffer.flip();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        for (SampleInfo sampleInfo : this.mSampleInfoList) {
            sampleInfo.writeToBufferInfo(bufferInfo, i2);
            this.mMuxer.writeSampleData(getTrackIndexForSampleType(sampleInfo.mSampleType), this.mByteBuffer, bufferInfo);
            i2 += sampleInfo.mSize;
        }
        this.mSampleInfoList.clear();
        this.mByteBuffer = null;
    }

    public void setOutputFormat(SampleType sampleType, MediaFormat mediaFormat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, sampleType, mediaFormat) == null) {
            if (AnonymousClass1.$SwitchMap$com$baidu$searchbox$afx$recode$QueuedMuxer$SampleType[sampleType.ordinal()] == 1) {
                this.mVideoFormat = mediaFormat;
                onSetOutputFormat();
                return;
            }
            throw new AssertionError();
        }
    }

    public void writeSampleData(SampleType sampleType, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sampleType, byteBuffer, bufferInfo) == null) {
            if (this.mStarted) {
                this.mMuxer.writeSampleData(getTrackIndexForSampleType(sampleType), byteBuffer, bufferInfo);
                return;
            }
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            byteBuffer.position(bufferInfo.offset);
            if (this.mByteBuffer == null) {
                this.mByteBuffer = ByteBuffer.allocateDirect(65536).order(ByteOrder.nativeOrder());
            }
            this.mByteBuffer.put(byteBuffer);
            this.mSampleInfoList.add(new SampleInfo(sampleType, bufferInfo.size, bufferInfo, null));
        }
    }
}
