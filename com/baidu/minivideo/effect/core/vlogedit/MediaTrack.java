package com.baidu.minivideo.effect.core.vlogedit;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.android.imsdk.IMConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class MediaTrack implements Parcelable, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final Parcelable.Creator<MediaTrack> CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public String footerTransitionName;
    public float[] glClearColor;
    public String headerTransitionName;
    public List<MediaAEffectKeyData> mediaAEffectKeyData;
    public List<MediaSegment> mediaSegments;
    public List<MediaTransition> mediaTransitions;
    public MediaSegment superpositionFooter;
    public MediaSegment superpositionHeader;
    public String trackType;
    public String transitionMode;

    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator<MediaTrack> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public MediaTrack createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) ? new MediaTrack(parcel) : (MediaTrack) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public MediaTrack[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new MediaTrack[i2] : (MediaTrack[]) invokeI.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-447494936, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaTrack;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-447494936, "Lcom/baidu/minivideo/effect/core/vlogedit/MediaTrack;");
                return;
            }
        }
        CREATOR = new a();
    }

    public MediaTrack() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.transitionMode = IMConstants.SERVICE_TYPE_ORDER;
        this.glClearColor = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            try {
                MediaTrack mediaTrack = (MediaTrack) super.clone();
                if (this.superpositionHeader != null) {
                    mediaTrack.superpositionHeader = this.superpositionHeader.m37clone();
                }
                if (this.superpositionFooter != null) {
                    mediaTrack.superpositionFooter = this.superpositionFooter.m37clone();
                }
                if (this.mediaSegments != null) {
                    ArrayList arrayList = new ArrayList();
                    for (MediaSegment mediaSegment : this.mediaSegments) {
                        arrayList.add(mediaSegment.m37clone());
                    }
                    mediaTrack.mediaSegments = arrayList;
                }
                if (this.mediaTransitions != null) {
                    ArrayList arrayList2 = new ArrayList();
                    for (MediaTransition mediaTransition : this.mediaTransitions) {
                        arrayList2.add((MediaTransition) mediaTransition.clone());
                    }
                    mediaTrack.mediaTransitions = arrayList2;
                }
                if (this.headerTransitionName != null) {
                    mediaTrack.headerTransitionName = this.headerTransitionName;
                }
                if (this.footerTransitionName != null) {
                    mediaTrack.footerTransitionName = this.footerTransitionName;
                }
                if (this.transitionMode != null) {
                    mediaTrack.transitionMode = this.transitionMode;
                }
                if (this.trackType != null) {
                    mediaTrack.trackType = this.trackType;
                }
                if (this.mediaAEffectKeyData != null) {
                    mediaTrack.mediaAEffectKeyData = new ArrayList();
                    for (MediaAEffectKeyData mediaAEffectKeyData : this.mediaAEffectKeyData) {
                        mediaTrack.mediaAEffectKeyData.add(mediaAEffectKeyData.m36clone());
                    }
                }
                return mediaTrack;
            } catch (Exception e2) {
                e2.printStackTrace();
                return new MediaTrack();
            }
        }
        return invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, parcel, i2) == null) {
            parcel.writeTypedList(this.mediaSegments);
            parcel.writeTypedList(this.mediaTransitions);
            parcel.writeString(this.trackType);
            parcel.writeParcelable(this.superpositionHeader, i2);
            parcel.writeParcelable(this.superpositionFooter, i2);
            parcel.writeString(this.headerTransitionName);
            parcel.writeString(this.footerTransitionName);
            parcel.writeString(this.transitionMode);
            parcel.writeTypedList(this.mediaAEffectKeyData);
            parcel.writeFloatArray(this.glClearColor);
        }
    }

    public MediaTrack(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.transitionMode = IMConstants.SERVICE_TYPE_ORDER;
        this.glClearColor = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.mediaSegments = parcel.createTypedArrayList(MediaSegment.CREATOR);
        this.mediaTransitions = parcel.createTypedArrayList(MediaTransition.CREATOR);
        this.trackType = parcel.readString();
        this.superpositionHeader = (MediaSegment) parcel.readParcelable(MediaSegment.class.getClassLoader());
        this.superpositionFooter = (MediaSegment) parcel.readParcelable(MediaSegment.class.getClassLoader());
        this.headerTransitionName = parcel.readString();
        this.footerTransitionName = parcel.readString();
        this.transitionMode = parcel.readString();
        this.mediaAEffectKeyData = parcel.createTypedArrayList(MediaAEffectKeyData.CREATOR);
        this.glClearColor = parcel.createFloatArray();
    }
}
