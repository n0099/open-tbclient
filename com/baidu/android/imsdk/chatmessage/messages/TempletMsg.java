package com.baidu.android.imsdk.chatmessage.messages;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.NoProGuard;
import com.baidu.mobstat.Config;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class TempletMsg extends NormalMsg {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator CREATOR;
    public static final int IMAGE = 2;
    public static final int LINK = 1;
    public static final int NO_FOOT = 0;
    public static final int VIDEO = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public Commodity[] mCommodity;
    public String mDetailurl;
    public String mFirstColor;
    public String mFirstName;
    public Image mImage;
    public String mImageDetail;
    public String mKeywords;
    public ArrayList mLinks;
    public int mMode;
    public String mRemarkColor;
    public String mRemarkName;
    public String mTitle;
    public Video mVideo;

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes.dex */
    public class Commodity implements Parcelable, NoProGuard {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String mColor;
        public String mName;
        public String mValue;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(137938172, "Lcom/baidu/android/imsdk/chatmessage/messages/TempletMsg$Commodity;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(137938172, "Lcom/baidu/android/imsdk/chatmessage/messages/TempletMsg$Commodity;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.messages.TempletMsg.Commodity.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Commodity createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new Commodity(parcel);
                    }
                    return (Commodity) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Commodity[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new Commodity[i];
                    }
                    return (Commodity[]) invokeI.objValue;
                }
            };
        }

        public Commodity() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public String getColor() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mColor;
            }
            return (String) invokeV.objValue;
        }

        public String getName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.mName;
            }
            return (String) invokeV.objValue;
        }

        public String getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.mValue;
            }
            return (String) invokeV.objValue;
        }

        public Commodity(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mName = parcel.readString();
            this.mValue = parcel.readString();
            this.mColor = parcel.readString();
        }

        public void setColor(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                this.mColor = str;
            }
        }

        public void setName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
                this.mName = str;
            }
        }

        public void setValue(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
                this.mValue = str;
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048583, this, parcel, i) == null) {
                parcel.writeString(this.mName);
                parcel.writeString(this.mValue);
                parcel.writeString(this.mColor);
            }
        }
    }

    /* loaded from: classes.dex */
    public class Image implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String description;
        public String image;
        public String title;
        public String url;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1688194958, "Lcom/baidu/android/imsdk/chatmessage/messages/TempletMsg$Image;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1688194958, "Lcom/baidu/android/imsdk/chatmessage/messages/TempletMsg$Image;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.messages.TempletMsg.Image.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Image createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new Image(parcel);
                    }
                    return (Image) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Image[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new Image[i];
                    }
                    return (Image[]) invokeI.objValue;
                }
            };
        }

        public Image() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public String getDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.description;
            }
            return (String) invokeV.objValue;
        }

        public String getImage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.image;
            }
            return (String) invokeV.objValue;
        }

        public String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.url;
            }
            return (String) invokeV.objValue;
        }

        public Image(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.image = parcel.readString();
            this.url = parcel.readString();
            this.title = parcel.readString();
            this.description = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048581, this, parcel, i) == null) {
                parcel.writeString(this.image);
                parcel.writeString(this.url);
                parcel.writeString(this.title);
                parcel.writeString(this.description);
            }
        }
    }

    /* loaded from: classes.dex */
    public class Link implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String content;
        public String title;
        public String url;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1165500531, "Lcom/baidu/android/imsdk/chatmessage/messages/TempletMsg$Link;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1165500531, "Lcom/baidu/android/imsdk/chatmessage/messages/TempletMsg$Link;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.messages.TempletMsg.Link.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Link createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new Link(parcel);
                    }
                    return (Link) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Link[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new Link[i];
                    }
                    return (Link[]) invokeI.objValue;
                }
            };
        }

        public Link() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public String getContent() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.content;
            }
            return (String) invokeV.objValue;
        }

        public String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.url;
            }
            return (String) invokeV.objValue;
        }

        public Link(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.content = parcel.readString();
            this.title = parcel.readString();
            this.url = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048580, this, parcel, i) == null) {
                parcel.writeString(this.content);
                parcel.writeString(this.title);
                parcel.writeString(this.url);
            }
        }
    }

    /* loaded from: classes.dex */
    public class Video implements Parcelable {
        public static /* synthetic */ Interceptable $ic;
        public static final Parcelable.Creator CREATOR;
        public transient /* synthetic */ FieldHolder $fh;
        public String cover;
        public String description;
        public String duration;
        public String title;
        public String url;

        @Override // android.os.Parcelable
        public int describeContents() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0;
            }
            return invokeV.intValue;
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2056767598, "Lcom/baidu/android/imsdk/chatmessage/messages/TempletMsg$Video;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(2056767598, "Lcom/baidu/android/imsdk/chatmessage/messages/TempletMsg$Video;");
                    return;
                }
            }
            CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.messages.TempletMsg.Video.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                        }
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Video createFromParcel(Parcel parcel) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                        return new Video(parcel);
                    }
                    return (Video) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                public Video[] newArray(int i) {
                    InterceptResult invokeI;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                        return new Video[i];
                    }
                    return (Video[]) invokeI.objValue;
                }
            };
        }

        public Video() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public String getCover() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.cover;
            }
            return (String) invokeV.objValue;
        }

        public String getDescription() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.description;
            }
            return (String) invokeV.objValue;
        }

        public String getDuration() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.duration;
            }
            return (String) invokeV.objValue;
        }

        public String getTitle() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.title;
            }
            return (String) invokeV.objValue;
        }

        public String getUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.url;
            }
            return (String) invokeV.objValue;
        }

        public Video(Parcel parcel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {parcel};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.cover = parcel.readString();
            this.url = parcel.readString();
            this.title = parcel.readString();
            this.description = parcel.readString();
            this.duration = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048582, this, parcel, i) == null) {
                parcel.writeString(this.cover);
                parcel.writeString(this.url);
                parcel.writeString(this.title);
                parcel.writeString(this.description);
                parcel.writeString(this.duration);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1700027333, "Lcom/baidu/android/imsdk/chatmessage/messages/TempletMsg;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1700027333, "Lcom/baidu/android/imsdk/chatmessage/messages/TempletMsg;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator() { // from class: com.baidu.android.imsdk.chatmessage.messages.TempletMsg.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public TempletMsg createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new TempletMsg(parcel);
                }
                return (TempletMsg) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public TempletMsg[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new TempletMsg[i];
                }
                return (TempletMsg[]) invokeI.objValue;
            }
        };
    }

    public TempletMsg() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMode = 0;
        this.mLinks = new ArrayList();
        setMsgType(12);
    }

    public Commodity[] getCommodity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mCommodity;
        }
        return (Commodity[]) invokeV.objValue;
    }

    public String getDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.mDetailurl;
        }
        return (String) invokeV.objValue;
    }

    public String getFirstColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mFirstColor;
        }
        return (String) invokeV.objValue;
    }

    public String getFirstName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.mFirstName;
        }
        return (String) invokeV.objValue;
    }

    public Image getImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.mImage;
        }
        return (Image) invokeV.objValue;
    }

    public String getImageDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.mImageDetail;
        }
        return (String) invokeV.objValue;
    }

    public String getKeywords() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.mKeywords;
        }
        return (String) invokeV.objValue;
    }

    public ArrayList getLinks() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.mLinks;
        }
        return (ArrayList) invokeV.objValue;
    }

    public int getMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.mMode;
        }
        return invokeV.intValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public String getRecommendDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (!TextUtils.isEmpty(this.mTitle)) {
                return this.mTitle;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public String getRemarkColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mRemarkColor;
        }
        return (String) invokeV.objValue;
    }

    public String getRemarkName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.mRemarkName;
        }
        return (String) invokeV.objValue;
    }

    public String getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mTitle;
        }
        return (String) invokeV.objValue;
    }

    public Video getVideo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mVideo;
        }
        return (Video) invokeV.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TempletMsg(Parcel parcel) {
        super(parcel);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Parcel) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mMode = 0;
        this.mLinks = new ArrayList();
        this.mTitle = parcel.readString();
        this.mDetailurl = parcel.readString();
        this.mFirstName = parcel.readString();
        this.mFirstColor = parcel.readString();
        this.mRemarkName = parcel.readString();
        this.mRemarkColor = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            Commodity[] commodityArr = new Commodity[readInt];
            this.mCommodity = commodityArr;
            parcel.readTypedArray(commodityArr, Commodity.CREATOR);
        }
        this.mMode = parcel.readInt();
        this.mLinks = parcel.createTypedArrayList(Link.CREATOR);
        this.mImage = (Image) parcel.readParcelable(Image.class.getClassLoader());
        this.mVideo = (Video) parcel.readParcelable(Video.class.getClassLoader());
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg
    public boolean parseJsonString() {
        InterceptResult invokeV;
        JSONArray jSONArray;
        int length;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject(getJsonContent());
                String optString = jSONObject.optString("title");
                this.mTitle = optString;
                if (TextUtils.isEmpty(optString)) {
                    return false;
                }
                this.mDetailurl = jSONObject.optString("detail_url");
                JSONObject optJSONObject = jSONObject.optJSONObject(Config.TRACE_VISIT_FIRST);
                if (optJSONObject != null) {
                    this.mFirstName = optJSONObject.optString("value");
                    this.mFirstColor = optJSONObject.optString("color");
                }
                JSONObject optJSONObject2 = jSONObject.optJSONObject("remark");
                if (optJSONObject2 != null) {
                    this.mRemarkName = optJSONObject2.optString("value");
                    this.mRemarkColor = optJSONObject2.optString("color");
                }
                JSONArray optJSONArray = jSONObject.optJSONArray("keywords");
                if (optJSONArray != null) {
                    this.mKeywords = optJSONArray.toString();
                    int length2 = optJSONArray.length();
                    if (length2 > 0) {
                        this.mCommodity = new Commodity[length2];
                    }
                    LogUtils.d("TempletMsg", "size is " + length2);
                    for (int i = 0; i < length2; i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        Commodity commodity = new Commodity();
                        commodity.setName(jSONObject2.getString("name"));
                        commodity.setValue(jSONObject2.optString("value", ""));
                        commodity.setColor(jSONObject2.optString("color", "#000000"));
                        this.mCommodity[i] = commodity;
                    }
                }
                JSONObject optJSONObject3 = jSONObject.optJSONObject("image");
                if (optJSONObject3 != null) {
                    this.mImageDetail = optJSONObject3.toString();
                }
                if (jSONObject.has("footer") && (length = (jSONArray = jSONObject.getJSONArray("footer")).length()) > 0) {
                    String string = jSONArray.getJSONObject(0).getString("type");
                    char c = 65535;
                    int hashCode = string.hashCode();
                    if (hashCode != 3321850) {
                        if (hashCode != 100313435) {
                            if (hashCode == 112202875 && string.equals("video")) {
                                c = 2;
                            }
                        } else if (string.equals("image")) {
                            c = 1;
                        }
                    } else if (string.equals("link")) {
                        c = 0;
                    }
                    if (c != 0) {
                        if (c != 1) {
                            this.mMode = 3;
                            Video video = new Video();
                            this.mVideo = video;
                            video.cover = jSONArray.getJSONObject(0).getString(AlaLiveRoomActivityConfig.SDK_LIVE_COVER_KEY);
                            this.mVideo.url = jSONArray.getJSONObject(0).getString("url");
                            this.mVideo.title = jSONArray.getJSONObject(0).getString("title");
                            this.mVideo.description = jSONArray.getJSONObject(0).getString("description");
                            this.mVideo.duration = jSONArray.getJSONObject(0).getString("duration");
                        } else {
                            this.mMode = 2;
                            Image image = new Image();
                            this.mImage = image;
                            image.image = jSONArray.getJSONObject(0).getString("image");
                            this.mImage.url = jSONArray.getJSONObject(0).getString("url");
                            this.mImage.title = jSONArray.getJSONObject(0).getString("title");
                            this.mImage.description = jSONArray.getJSONObject(0).getString("description");
                        }
                    } else {
                        this.mMode = 1;
                        this.mLinks.clear();
                        if (length > 3) {
                            length = 3;
                        }
                        for (int i2 = 0; i2 < length; i2++) {
                            Link link = new Link();
                            link.content = jSONArray.getJSONObject(i2).getString("content");
                            link.title = jSONArray.getJSONObject(i2).optString("detail_title");
                            link.url = jSONArray.getJSONObject(i2).getString("detail_url");
                            this.mLinks.add(link);
                        }
                        return true;
                    }
                }
                return true;
            } catch (JSONException e) {
                LogUtils.e("TempletMsg", "parseJsonString JSONException", e);
                return false;
            }
        }
        return invokeV.booleanValue;
    }

    public boolean setJsonContent(String str, String str2, String str3, String str4, String str5, Commodity[] commodityArr, String str6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{str, str2, str3, str4, str5, commodityArr, str6})) == null) {
            if (TextUtils.isEmpty(str) || str2 == null || str4 == null) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            try {
                jSONObject.put("title", str);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("value", str2);
                jSONObject2.put("color", str3);
                jSONObject.put(Config.TRACE_VISIT_FIRST, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("value", str4);
                jSONObject3.put("color", str5);
                jSONObject.put("remark", jSONObject3);
                if (commodityArr != null && commodityArr.length > 0) {
                    for (Commodity commodity : commodityArr) {
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("name", commodity.getName());
                        jSONObject4.put("color", commodity.getColor());
                        jSONObject4.put("value", commodity.getValue());
                        jSONArray.put(jSONObject4);
                    }
                }
                jSONObject.put("keywords", jSONArray);
                jSONObject.put("detail_url", str6);
                return setMsgContent(jSONObject.toString());
            } catch (Exception unused) {
                LogUtils.e("TempletMsg", "content error!");
                return false;
            }
        }
        return invokeCommon.booleanValue;
    }

    @Override // com.baidu.android.imsdk.chatmessage.messages.ChatMsg, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048593, this, parcel, i) == null) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.mTitle);
            parcel.writeString(this.mDetailurl);
            parcel.writeString(this.mFirstName);
            parcel.writeString(this.mFirstColor);
            parcel.writeString(this.mRemarkName);
            parcel.writeString(this.mRemarkColor);
            Commodity[] commodityArr = this.mCommodity;
            if (commodityArr != null) {
                i2 = commodityArr.length;
            } else {
                i2 = 0;
            }
            parcel.writeInt(i2);
            if (i2 > 0) {
                parcel.writeTypedArray(this.mCommodity, i);
            }
            parcel.writeInt(this.mMode);
            parcel.writeTypedList(this.mLinks);
            parcel.writeParcelable(this.mImage, i);
            parcel.writeParcelable(this.mVideo, i);
        }
    }
}
