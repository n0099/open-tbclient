package com.baidu.swan.apps.publisher;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.f1.e.b;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\r\u0018\u0000 @2\u00020\u0001:\u0001@B\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b=\u0010>B¯\u0001\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010;\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010.\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\b\u00100\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u00102\u001a\u00020\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\b\u00109\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\u0006\u0010$\u001a\u00020#\u0012\u000e\u00105\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u000104\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b=\u0010?J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\u0007J\u000f\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\n\u0010\u0007J\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u0015R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u0013\u001a\u0004\b\u001b\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004R\u001b\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u0015R\u001b\u0010!\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b\"\u0010\u0015R\u0019\u0010$\u001a\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010(\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010\u001d\u001a\u0004\b)\u0010\u0004R\u0019\u0010*\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010\u001d\u001a\u0004\b+\u0010\u0004R\u0019\u0010,\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b-\u0010\u0004R\u001b\u0010.\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010\u0013\u001a\u0004\b/\u0010\u0015R\u001b\u00100\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b0\u0010\u0013\u001a\u0004\b1\u0010\u0015R\u0019\u00102\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b2\u0010\u001d\u001a\u0004\b3\u0010\u0004R!\u00105\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u001b\u00109\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b9\u0010\u0013\u001a\u0004\b:\u0010\u0015R\u001b\u0010;\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b;\u0010\u0013\u001a\u0004\b<\u0010\u0015¨\u0006A"}, d2 = {"Lcom/baidu/swan/apps/publisher/PublishParams;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "", "supportEmoji", "()Ljava/lang/Boolean;", "supportImage", "supportTarget", "supportTitle", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "Ljava/lang/String;", "getAppId", "()Ljava/lang/String;", "appVersion", "getAppVersion", "callback", "getCallback", "cancelText", "getCancelText", "cancelTextColor", "I", "getCancelTextColor", "contentHint", "getContentHint", "emojiPath", "getEmojiPath", "", "imageRatio", "F", "getImageRatio", "()F", "maxImageNum", "getMaxImageNum", "navBarBgColor", "getNavBarBgColor", "navBarTextColor", "getNavBarTextColor", "navBarTitle", "getNavBarTitle", "publishText", "getPublishText", "publishTextColor", "getPublishTextColor", "", "showList", "Ljava/util/List;", "getShowList", "()Ljava/util/List;", "target", "getTarget", "titleHint", "getTitleHint", "<init>", "(Landroid/os/Parcel;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "CREATOR", "core_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes3.dex */
public final class PublishParams implements Parcelable {
    public static /* synthetic */ Interceptable $ic;
    public static final a CREATOR;
    public transient /* synthetic */ FieldHolder $fh;
    public final String appId;
    public final String appVersion;
    public final String callback;
    public final String cancelText;
    public final int cancelTextColor;
    public final String contentHint;
    public final String emojiPath;
    public final float imageRatio;
    public final int maxImageNum;
    public final int navBarBgColor;
    public final int navBarTextColor;
    public final String navBarTitle;
    public final String publishText;
    public final int publishTextColor;
    public final List<String> showList;
    public final String target;
    public final String titleHint;

    /* loaded from: classes3.dex */
    public static final class a implements Parcelable.Creator<PublishParams> {
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
        public PublishParams createFromParcel(Parcel parcel) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, parcel)) == null) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new PublishParams(parcel);
            }
            return (PublishParams) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public PublishParams[] newArray(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? new PublishParams[i2] : (PublishParams[]) invokeI.objValue;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(749520006, "Lcom/baidu/swan/apps/publisher/PublishParams;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(749520006, "Lcom/baidu/swan/apps/publisher/PublishParams;");
                return;
            }
        }
        CREATOR = new a(null);
    }

    public PublishParams(String str, String str2, String str3, int i2, int i3, String str4, int i4, String str5, int i5, String str6, String str7, String str8, int i6, float f2, List<String> list, String str9, String str10) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, str3, Integer.valueOf(i2), Integer.valueOf(i3), str4, Integer.valueOf(i4), str5, Integer.valueOf(i5), str6, str7, str8, Integer.valueOf(i6), Float.valueOf(f2), list, str9, str10};
            interceptable.invokeUnInit(65538, newInitContext);
            int i7 = newInitContext.flag;
            if ((i7 & 1) != 0) {
                int i8 = i7 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.contentHint = str;
        this.titleHint = str2;
        this.navBarTitle = str3;
        this.navBarTextColor = i2;
        this.navBarBgColor = i3;
        this.publishText = str4;
        this.publishTextColor = i4;
        this.cancelText = str5;
        this.cancelTextColor = i5;
        this.target = str6;
        this.emojiPath = str7;
        this.callback = str8;
        this.maxImageNum = i6;
        this.imageRatio = f2;
        this.showList = list;
        this.appId = str9;
        this.appVersion = str10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public final String getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appId : (String) invokeV.objValue;
    }

    public final String getAppVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.appVersion : (String) invokeV.objValue;
    }

    public final String getCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.callback : (String) invokeV.objValue;
    }

    public final String getCancelText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.cancelText : (String) invokeV.objValue;
    }

    public final int getCancelTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.cancelTextColor : invokeV.intValue;
    }

    public final String getContentHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.contentHint : (String) invokeV.objValue;
    }

    public final String getEmojiPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.emojiPath : (String) invokeV.objValue;
    }

    public final float getImageRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.imageRatio : invokeV.floatValue;
    }

    public final int getMaxImageNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.maxImageNum : invokeV.intValue;
    }

    public final int getNavBarBgColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.navBarBgColor : invokeV.intValue;
    }

    public final int getNavBarTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.navBarTextColor : invokeV.intValue;
    }

    public final String getNavBarTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.navBarTitle : (String) invokeV.objValue;
    }

    public final String getPublishText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.publishText : (String) invokeV.objValue;
    }

    public final int getPublishTextColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.publishTextColor : invokeV.intValue;
    }

    public final List<String> getShowList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.showList : (List) invokeV.objValue;
    }

    public final String getTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.target : (String) invokeV.objValue;
    }

    public final String getTitleHint() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.titleHint : (String) invokeV.objValue;
    }

    public final Boolean supportEmoji() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            List<String> list = this.showList;
            if (list != null) {
                return Boolean.valueOf(list.contains(ReplyEditorParams.MODULE_EMOJI));
            }
            return null;
        }
        return (Boolean) invokeV.objValue;
    }

    public final Boolean supportImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            List<String> list = this.showList;
            if (list != null) {
                return Boolean.valueOf(list.contains("image"));
            }
            return null;
        }
        return (Boolean) invokeV.objValue;
    }

    public final Boolean supportTarget() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            List<String> list = this.showList;
            if (list != null) {
                return Boolean.valueOf(list.contains("target"));
            }
            return null;
        }
        return (Boolean) invokeV.objValue;
    }

    public final Boolean supportTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            List<String> list = this.showList;
            if (list != null) {
                return Boolean.valueOf(list.contains("title"));
            }
            return null;
        }
        return (Boolean) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048598, this, parcel, i2) == null) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.contentHint);
            parcel.writeString(this.titleHint);
            parcel.writeString(this.navBarTitle);
            parcel.writeInt(this.navBarTextColor);
            parcel.writeInt(this.navBarBgColor);
            parcel.writeString(this.publishText);
            parcel.writeInt(this.publishTextColor);
            parcel.writeString(this.cancelText);
            parcel.writeInt(this.cancelTextColor);
            parcel.writeString(this.target);
            parcel.writeString(this.emojiPath);
            parcel.writeString(this.callback);
            parcel.writeInt(this.maxImageNum);
            parcel.writeFloat(this.imageRatio);
            parcel.writeStringList(this.showList);
            parcel.writeString(this.appId);
            parcel.writeString(this.appVersion);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PublishParams(String str, String str2, String str3, int i2, int i3, String str4, int i4, String str5, int i5, String str6, String str7, String str8, int i6, float f2, List list, String str9, String str10, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i2, i3, str4, i4, str5, i5, str6, str7, str8, i6, f2, list, r18, r19);
        String str11;
        String str12;
        b.a N;
        b.a N2;
        if ((i7 & 32768) != 0) {
            e i8 = e.i();
            str11 = (i8 == null || (N2 = i8.N()) == null) ? null : N2.H();
        } else {
            str11 = str9;
        }
        if ((i7 & 65536) != 0) {
            e i9 = e.i();
            str12 = (i9 == null || (N = i9.N()) == null) ? null : N.u1();
        } else {
            str12 = str10;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PublishParams(Parcel parcel) {
        this(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readFloat(), parcel.createStringArrayList(), parcel.readString(), parcel.readString());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((String) objArr2[0], (String) objArr2[1], (String) objArr2[2], ((Integer) objArr2[3]).intValue(), ((Integer) objArr2[4]).intValue(), (String) objArr2[5], ((Integer) objArr2[6]).intValue(), (String) objArr2[7], ((Integer) objArr2[8]).intValue(), (String) objArr2[9], (String) objArr2[10], (String) objArr2[11], ((Integer) objArr2[12]).intValue(), ((Float) objArr2[13]).floatValue(), (List) objArr2[14], (String) objArr2[15], (String) objArr2[16]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(parcel, "parcel");
    }
}
