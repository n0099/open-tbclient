package android.support.v4.media;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Set;
/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Parcelable.Creator CREATOR;
    public static final ArrayMap METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    public static final int METADATA_TYPE_BITMAP = 2;
    public static final int METADATA_TYPE_LONG = 0;
    public static final int METADATA_TYPE_RATING = 3;
    public static final int METADATA_TYPE_TEXT = 1;
    public static final String[] PREFERRED_BITMAP_ORDER;
    public static final String[] PREFERRED_DESCRIPTION_ORDER;
    public static final String[] PREFERRED_URI_ORDER;
    public static final String TAG = "MediaMetadata";
    public transient /* synthetic */ FieldHolder $fh;
    public final Bundle mBundle;
    public MediaDescriptionCompat mDescription;
    public MediaMetadata mMetadataFwk;

    @Override // android.os.Parcelable
    public int describeContents() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes.dex */
    public final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Bundle mBundle;

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
                    return;
                }
            }
            this.mBundle = new Bundle();
        }

        public MediaMetadataCompat build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new MediaMetadataCompat(this.mBundle);
            }
            return (MediaMetadataCompat) invokeV.objValue;
        }

        public Builder(MediaMetadataCompat mediaMetadataCompat) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaMetadataCompat};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            Bundle bundle = new Bundle(mediaMetadataCompat.mBundle);
            this.mBundle = bundle;
            MediaSessionCompat.ensureClassLoader(bundle);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Builder(MediaMetadataCompat mediaMetadataCompat, int i) {
            this(mediaMetadataCompat);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaMetadataCompat, Integer.valueOf(i)};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    this((MediaMetadataCompat) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            for (String str : this.mBundle.keySet()) {
                Object obj = this.mBundle.get(str);
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (bitmap.getHeight() > i || bitmap.getWidth() > i) {
                        putBitmap(str, scaleBitmap(bitmap, i));
                    }
                }
            }
        }

        private Bitmap scaleBitmap(Bitmap bitmap, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, this, bitmap, i)) == null) {
                float f = i;
                float min = Math.min(f / bitmap.getWidth(), f / bitmap.getHeight());
                return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * min), (int) (bitmap.getHeight() * min), true);
            }
            return (Bitmap) invokeLI.objValue;
        }

        public Builder putBitmap(String str, Bitmap bitmap) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bitmap)) == null) {
                if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) && ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() != 2) {
                    throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
                }
                this.mBundle.putParcelable(str, bitmap);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder putLong(String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
                if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) && ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() != 0) {
                    throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
                }
                this.mBundle.putLong(str, j);
                return this;
            }
            return (Builder) invokeLJ.objValue;
        }

        public Builder putRating(String str, RatingCompat ratingCompat) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, ratingCompat)) == null) {
                if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) && ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() != 3) {
                    throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
                }
                if (Build.VERSION.SDK_INT >= 19) {
                    this.mBundle.putParcelable(str, (Parcelable) ratingCompat.getRating());
                } else {
                    this.mBundle.putParcelable(str, ratingCompat);
                }
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder putString(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, str2)) == null) {
                if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) && ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() != 1) {
                    throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
                }
                this.mBundle.putCharSequence(str, str2);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }

        public Builder putText(String str, CharSequence charSequence) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, charSequence)) == null) {
                if (MediaMetadataCompat.METADATA_KEYS_TYPE.containsKey(str) && ((Integer) MediaMetadataCompat.METADATA_KEYS_TYPE.get(str)).intValue() != 1) {
                    throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
                }
                this.mBundle.putCharSequence(str, charSequence);
                return this;
            }
            return (Builder) invokeLL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1796148426, "Landroid/support/v4/media/MediaMetadataCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1796148426, "Landroid/support/v4/media/MediaMetadataCompat;");
                return;
            }
        }
        ArrayMap arrayMap = new ArrayMap();
        METADATA_KEYS_TYPE = arrayMap;
        arrayMap.put("android.media.metadata.TITLE", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.ARTIST", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.DURATION", 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.AUTHOR", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.WRITER", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.COMPOSER", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.COMPILATION", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.DATE", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.YEAR", 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.GENRE", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.TRACK_NUMBER", 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.NUM_TRACKS", 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISC_NUMBER", 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ARTIST", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.ART", 2);
        METADATA_KEYS_TYPE.put("android.media.metadata.ART_URI", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART", 2);
        METADATA_KEYS_TYPE.put("android.media.metadata.ALBUM_ART_URI", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.USER_RATING", 3);
        METADATA_KEYS_TYPE.put("android.media.metadata.RATING", 3);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_TITLE", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON", 2);
        METADATA_KEYS_TYPE.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_ID", 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_URI", 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ADVERTISEMENT, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        PREFERRED_DESCRIPTION_ORDER = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        PREFERRED_BITMAP_ORDER = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        PREFERRED_URI_ORDER = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new Parcelable.Creator() { // from class: android.support.v4.media.MediaMetadataCompat.1
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
            public MediaMetadataCompat createFromParcel(Parcel parcel) {
                InterceptResult invokeL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, parcel)) == null) {
                    return new MediaMetadataCompat(parcel);
                }
                return (MediaMetadataCompat) invokeL.objValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            public MediaMetadataCompat[] newArray(int i) {
                InterceptResult invokeI;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeI = interceptable2.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                    return new MediaMetadataCompat[i];
                }
                return (MediaMetadataCompat[]) invokeI.objValue;
            }
        };
    }

    public MediaMetadataCompat(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Bundle bundle2 = new Bundle(bundle);
        this.mBundle = bundle2;
        MediaSessionCompat.ensureClassLoader(bundle2);
    }

    public static MediaMetadataCompat fromMediaMetadata(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            if (obj != null && Build.VERSION.SDK_INT >= 21) {
                Parcel obtain = Parcel.obtain();
                MediaMetadata mediaMetadata = (MediaMetadata) obj;
                mediaMetadata.writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                MediaMetadataCompat mediaMetadataCompat = (MediaMetadataCompat) CREATOR.createFromParcel(obtain);
                obtain.recycle();
                mediaMetadataCompat.mMetadataFwk = mediaMetadata;
                return mediaMetadataCompat;
            }
            return null;
        }
        return (MediaMetadataCompat) invokeL.objValue;
    }

    public RatingCompat getRating(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            try {
                if (Build.VERSION.SDK_INT >= 19) {
                    return RatingCompat.fromRating(this.mBundle.getParcelable(str));
                }
                return (RatingCompat) this.mBundle.getParcelable(str);
            } catch (Exception e) {
                Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e);
                return null;
            }
        }
        return (RatingCompat) invokeL.objValue;
    }

    public MediaMetadataCompat(Parcel parcel) {
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
        this.mBundle = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    public boolean containsKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.mBundle.containsKey(str);
        }
        return invokeL.booleanValue;
    }

    public Bitmap getBitmap(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            try {
                return (Bitmap) this.mBundle.getParcelable(str);
            } catch (Exception e) {
                Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e);
                return null;
            }
        }
        return (Bitmap) invokeL.objValue;
    }

    public long getLong(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return this.mBundle.getLong(str, 0L);
        }
        return invokeL.longValue;
    }

    public String getString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            CharSequence charSequence = this.mBundle.getCharSequence(str);
            if (charSequence != null) {
                return charSequence.toString();
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public CharSequence getText(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            return this.mBundle.getCharSequence(str);
        }
        return (CharSequence) invokeL.objValue;
    }

    public Bundle getBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return new Bundle(this.mBundle);
        }
        return (Bundle) invokeV.objValue;
    }

    public Set keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.mBundle.keySet();
        }
        return (Set) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.mBundle.size();
        }
        return invokeV.intValue;
    }

    public MediaDescriptionCompat getDescription() {
        InterceptResult invokeV;
        Uri uri;
        Bitmap bitmap;
        Uri uri2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            MediaDescriptionCompat mediaDescriptionCompat = this.mDescription;
            if (mediaDescriptionCompat != null) {
                return mediaDescriptionCompat;
            }
            String string = getString("android.media.metadata.MEDIA_ID");
            CharSequence[] charSequenceArr = new CharSequence[3];
            CharSequence text = getText("android.media.metadata.DISPLAY_TITLE");
            if (!TextUtils.isEmpty(text)) {
                charSequenceArr[0] = text;
                charSequenceArr[1] = getText("android.media.metadata.DISPLAY_SUBTITLE");
                charSequenceArr[2] = getText("android.media.metadata.DISPLAY_DESCRIPTION");
            } else {
                int i = 0;
                int i2 = 0;
                while (i < 3) {
                    String[] strArr = PREFERRED_DESCRIPTION_ORDER;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    int i3 = i2 + 1;
                    CharSequence text2 = getText(strArr[i2]);
                    if (!TextUtils.isEmpty(text2)) {
                        charSequenceArr[i] = text2;
                        i++;
                    }
                    i2 = i3;
                }
            }
            int i4 = 0;
            while (true) {
                String[] strArr2 = PREFERRED_BITMAP_ORDER;
                uri = null;
                if (i4 < strArr2.length) {
                    bitmap = getBitmap(strArr2[i4]);
                    if (bitmap != null) {
                        break;
                    }
                    i4++;
                } else {
                    bitmap = null;
                    break;
                }
            }
            int i5 = 0;
            while (true) {
                String[] strArr3 = PREFERRED_URI_ORDER;
                if (i5 < strArr3.length) {
                    String string2 = getString(strArr3[i5]);
                    if (!TextUtils.isEmpty(string2)) {
                        uri2 = Uri.parse(string2);
                        break;
                    }
                    i5++;
                } else {
                    uri2 = null;
                    break;
                }
            }
            String string3 = getString("android.media.metadata.MEDIA_URI");
            if (!TextUtils.isEmpty(string3)) {
                uri = Uri.parse(string3);
            }
            MediaDescriptionCompat.Builder builder = new MediaDescriptionCompat.Builder();
            builder.setMediaId(string);
            builder.setTitle(charSequenceArr[0]);
            builder.setSubtitle(charSequenceArr[1]);
            builder.setDescription(charSequenceArr[2]);
            builder.setIconBitmap(bitmap);
            builder.setIconUri(uri2);
            builder.setMediaUri(uri);
            Bundle bundle = new Bundle();
            if (this.mBundle.containsKey(METADATA_KEY_BT_FOLDER_TYPE)) {
                bundle.putLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE, getLong(METADATA_KEY_BT_FOLDER_TYPE));
            }
            if (this.mBundle.containsKey(METADATA_KEY_DOWNLOAD_STATUS)) {
                bundle.putLong(MediaDescriptionCompat.EXTRA_DOWNLOAD_STATUS, getLong(METADATA_KEY_DOWNLOAD_STATUS));
            }
            if (!bundle.isEmpty()) {
                builder.setExtras(bundle);
            }
            MediaDescriptionCompat build = builder.build();
            this.mDescription = build;
            return build;
        }
        return (MediaDescriptionCompat) invokeV.objValue;
    }

    public Object getMediaMetadata() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mMetadataFwk == null && Build.VERSION.SDK_INT >= 21) {
                Parcel obtain = Parcel.obtain();
                writeToParcel(obtain, 0);
                obtain.setDataPosition(0);
                this.mMetadataFwk = (MediaMetadata) MediaMetadata.CREATOR.createFromParcel(obtain);
                obtain.recycle();
            }
            return this.mMetadataFwk;
        }
        return invokeV.objValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048588, this, parcel, i) == null) {
            parcel.writeBundle(this.mBundle);
        }
    }
}
