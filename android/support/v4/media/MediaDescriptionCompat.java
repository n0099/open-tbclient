package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompatApi21;
import android.support.v4.media.MediaDescriptionCompatApi23;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long BT_FOLDER_TYPE_ALBUMS = 2;
    public static final long BT_FOLDER_TYPE_ARTISTS = 3;
    public static final long BT_FOLDER_TYPE_GENRES = 4;
    public static final long BT_FOLDER_TYPE_MIXED = 0;
    public static final long BT_FOLDER_TYPE_PLAYLISTS = 5;
    public static final long BT_FOLDER_TYPE_TITLES = 1;
    public static final long BT_FOLDER_TYPE_YEARS = 6;
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String DESCRIPTION_KEY_MEDIA_URI = "android.support.v4.media.description.MEDIA_URI";
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final String DESCRIPTION_KEY_NULL_BUNDLE_FLAG = "android.support.v4.media.description.NULL_BUNDLE_FLAG";
    public static final String EXTRA_BT_FOLDER_TYPE = "android.media.extra.BT_FOLDER_TYPE";
    public static final String EXTRA_DOWNLOAD_STATUS = "android.media.extra.DOWNLOAD_STATUS";
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    public transient /* synthetic */ FieldHolder $fh;
    public final CharSequence mDescription;
    public Object mDescriptionObj;
    public final Bundle mExtras;
    public final Bitmap mIcon;
    public final Uri mIconUri;
    public final String mMediaId;
    public final Uri mMediaUri;
    public final CharSequence mSubtitle;
    public final CharSequence mTitle;

    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public CharSequence mDescription;
        public Bundle mExtras;
        public Bitmap mIcon;
        public Uri mIconUri;
        public String mMediaId;
        public Uri mMediaUri;
        public CharSequence mSubtitle;
        public CharSequence mTitle;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public MediaDescriptionCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new MediaDescriptionCompat(this.mMediaId, this.mTitle, this.mSubtitle, this.mDescription, this.mIcon, this.mIconUri, this.mExtras, this.mMediaUri) : (MediaDescriptionCompat) invokeV.objValue;
        }

        public Builder setDescription(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence)) == null) {
                this.mDescription = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setExtras(@Nullable Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle)) == null) {
                this.mExtras = bundle;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIconBitmap(@Nullable Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, bitmap)) == null) {
                this.mIcon = bitmap;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setIconUri(@Nullable Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, uri)) == null) {
                this.mIconUri = uri;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMediaId(@Nullable String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.mMediaId = str;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setMediaUri(@Nullable Uri uri) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, uri)) == null) {
                this.mMediaUri = uri;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setSubtitle(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, charSequence)) == null) {
                this.mSubtitle = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTitle(@Nullable CharSequence charSequence) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence)) == null) {
                this.mTitle = charSequence;
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1896285839, "Landroid/support/v4/media/MediaDescriptionCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1896285839, "Landroid/support/v4/media/MediaDescriptionCompat;");
                return;
            }
        }
        CREATOR = new Parcelable.Creator<MediaDescriptionCompat>() { // from class: android.support.v4.media.MediaDescriptionCompat.1
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
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaDescriptionCompat createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    if (Build.VERSION.SDK_INT < 21) {
                        return new MediaDescriptionCompat(parcel);
                    }
                    return MediaDescriptionCompat.fromMediaDescription(MediaDescriptionCompatApi21.fromParcel(parcel));
                }
                return (MediaDescriptionCompat) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public MediaDescriptionCompat[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                return (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? new MediaDescriptionCompat[i] : (MediaDescriptionCompat[]) invokeI.objValue;
            }
        };
    }

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, charSequence, charSequence2, charSequence3, bitmap, uri, bundle, uri2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mMediaId = str;
        this.mTitle = charSequence;
        this.mSubtitle = charSequence2;
        this.mDescription = charSequence3;
        this.mIcon = bitmap;
        this.mIconUri = uri;
        this.mExtras = bundle;
        this.mMediaUri = uri2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MediaDescriptionCompat fromMediaDescription(Object obj) {
        InterceptResult invokeL;
        Uri uri;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            Bundle bundle = null;
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            Builder builder = new Builder();
            builder.setMediaId(MediaDescriptionCompatApi21.getMediaId(obj));
            builder.setTitle(MediaDescriptionCompatApi21.getTitle(obj));
            builder.setSubtitle(MediaDescriptionCompatApi21.getSubtitle(obj));
            builder.setDescription(MediaDescriptionCompatApi21.getDescription(obj));
            builder.setIconBitmap(MediaDescriptionCompatApi21.getIconBitmap(obj));
            builder.setIconUri(MediaDescriptionCompatApi21.getIconUri(obj));
            Bundle extras = MediaDescriptionCompatApi21.getExtras(obj);
            if (extras != null) {
                MediaSessionCompat.ensureClassLoader(extras);
                uri = (Uri) extras.getParcelable(DESCRIPTION_KEY_MEDIA_URI);
            } else {
                uri = null;
            }
            if (uri != null) {
                if (!extras.containsKey(DESCRIPTION_KEY_NULL_BUNDLE_FLAG) || extras.size() != 2) {
                    extras.remove(DESCRIPTION_KEY_MEDIA_URI);
                    extras.remove(DESCRIPTION_KEY_NULL_BUNDLE_FLAG);
                }
                builder.setExtras(bundle);
                if (uri == null) {
                    builder.setMediaUri(uri);
                } else if (Build.VERSION.SDK_INT >= 23) {
                    builder.setMediaUri(MediaDescriptionCompatApi23.getMediaUri(obj));
                }
                MediaDescriptionCompat build = builder.build();
                build.mDescriptionObj = obj;
                return build;
            }
            bundle = extras;
            builder.setExtras(bundle);
            if (uri == null) {
            }
            MediaDescriptionCompat build2 = builder.build();
            build2.mDescriptionObj = obj;
            return build2;
        }
        return (MediaDescriptionCompat) invokeL.objValue;
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

    @Nullable
    public CharSequence getDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mDescription : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mExtras : (Bundle) invokeV.objValue;
    }

    @Nullable
    public Bitmap getIconBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mIcon : (Bitmap) invokeV.objValue;
    }

    @Nullable
    public Uri getIconUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mIconUri : (Uri) invokeV.objValue;
    }

    public Object getMediaDescription() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.mDescriptionObj == null && Build.VERSION.SDK_INT >= 21) {
                Object newInstance = MediaDescriptionCompatApi21.Builder.newInstance();
                MediaDescriptionCompatApi21.Builder.setMediaId(newInstance, this.mMediaId);
                MediaDescriptionCompatApi21.Builder.setTitle(newInstance, this.mTitle);
                MediaDescriptionCompatApi21.Builder.setSubtitle(newInstance, this.mSubtitle);
                MediaDescriptionCompatApi21.Builder.setDescription(newInstance, this.mDescription);
                MediaDescriptionCompatApi21.Builder.setIconBitmap(newInstance, this.mIcon);
                MediaDescriptionCompatApi21.Builder.setIconUri(newInstance, this.mIconUri);
                Bundle bundle = this.mExtras;
                if (Build.VERSION.SDK_INT < 23 && this.mMediaUri != null) {
                    if (bundle == null) {
                        bundle = new Bundle();
                        bundle.putBoolean(DESCRIPTION_KEY_NULL_BUNDLE_FLAG, true);
                    }
                    bundle.putParcelable(DESCRIPTION_KEY_MEDIA_URI, this.mMediaUri);
                }
                MediaDescriptionCompatApi21.Builder.setExtras(newInstance, bundle);
                if (Build.VERSION.SDK_INT >= 23) {
                    MediaDescriptionCompatApi23.Builder.setMediaUri(newInstance, this.mMediaUri);
                }
                Object build = MediaDescriptionCompatApi21.Builder.build(newInstance);
                this.mDescriptionObj = build;
                return build;
            }
            return this.mDescriptionObj;
        }
        return invokeV.objValue;
    }

    @Nullable
    public String getMediaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mMediaId : (String) invokeV.objValue;
    }

    @Nullable
    public Uri getMediaUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mMediaUri : (Uri) invokeV.objValue;
    }

    @Nullable
    public CharSequence getSubtitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSubtitle : (CharSequence) invokeV.objValue;
    }

    @Nullable
    public CharSequence getTitle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mTitle : (CharSequence) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ((Object) this.mTitle) + StringUtil.ARRAY_ELEMENT_SEPARATOR + ((Object) this.mSubtitle) + StringUtil.ARRAY_ELEMENT_SEPARATOR + ((Object) this.mDescription);
        }
        return (String) invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048587, this, parcel, i) == null) {
            if (Build.VERSION.SDK_INT < 21) {
                parcel.writeString(this.mMediaId);
                TextUtils.writeToParcel(this.mTitle, parcel, i);
                TextUtils.writeToParcel(this.mSubtitle, parcel, i);
                TextUtils.writeToParcel(this.mDescription, parcel, i);
                parcel.writeParcelable(this.mIcon, i);
                parcel.writeParcelable(this.mIconUri, i);
                parcel.writeBundle(this.mExtras);
                parcel.writeParcelable(this.mMediaUri, i);
                return;
            }
            MediaDescriptionCompatApi21.writeToParcel(getMediaDescription(), parcel, i);
        }
    }

    public MediaDescriptionCompat(Parcel parcel) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {parcel};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mMediaId = parcel.readString();
        this.mTitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mSubtitle = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.mDescription = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.mIcon = (Bitmap) parcel.readParcelable(classLoader);
        this.mIconUri = (Uri) parcel.readParcelable(classLoader);
        this.mExtras = parcel.readBundle(classLoader);
        this.mMediaUri = (Uri) parcel.readParcelable(classLoader);
    }
}
