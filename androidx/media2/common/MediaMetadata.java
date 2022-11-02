package androidx.media2.common;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.versionedparcelable.CustomVersionedParcelable;
import androidx.versionedparcelable.ParcelImpl;
import androidx.versionedparcelable.ParcelUtils;
import androidx.versionedparcelable.VersionedParcelable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public final class MediaMetadata extends CustomVersionedParcelable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long BROWSABLE_TYPE_ALBUMS = 2;
    public static final long BROWSABLE_TYPE_ARTISTS = 3;
    public static final long BROWSABLE_TYPE_GENRES = 4;
    public static final long BROWSABLE_TYPE_MIXED = 0;
    public static final long BROWSABLE_TYPE_NONE = -1;
    public static final long BROWSABLE_TYPE_PLAYLISTS = 5;
    public static final long BROWSABLE_TYPE_TITLES = 1;
    public static final long BROWSABLE_TYPE_YEARS = 6;
    public static final ArrayMap<String, Integer> METADATA_KEYS_TYPE;
    public static final String METADATA_KEY_ADVERTISEMENT = "androidx.media2.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BROWSABLE = "androidx.media2.metadata.BROWSABLE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "androidx.media2.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_EXTRAS = "androidx.media2.metadata.EXTRAS";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_PLAYABLE = "androidx.media2.metadata.PLAYABLE";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String METADATA_KEY_RADIO_FREQUENCY = "androidx.media2.metadata.RADIO_FREQUENCY";
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String METADATA_KEY_RADIO_PROGRAM_NAME = "androidx.media2.metadata.RADIO_PROGRAM_NAME";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    public static final int METADATA_TYPE_BITMAP = 2;
    public static final int METADATA_TYPE_BUNDLE = 5;
    public static final int METADATA_TYPE_FLOAT = 4;
    public static final int METADATA_TYPE_LONG = 0;
    public static final int METADATA_TYPE_RATING = 3;
    public static final int METADATA_TYPE_TEXT = 1;
    public static final long STATUS_DOWNLOADED = 2;
    public static final long STATUS_DOWNLOADING = 1;
    public static final long STATUS_NOT_DOWNLOADED = 0;
    public static final String TAG = "MediaMetadata";
    public transient /* synthetic */ FieldHolder $fh;
    public ParcelImplListSlice mBitmapListSlice;
    public Bundle mBundle;
    public Bundle mParcelableWithoutBitmapBundle;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface BitmapKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface BundleKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface FloatKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface LongKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface RatingKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes.dex */
    public @interface TextKey {
    }

    /* loaded from: classes.dex */
    public static final class BitmapEntry implements VersionedParcelable {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BITMAP_SIZE_LIMIT_IN_BYTES = 262144;
        public transient /* synthetic */ FieldHolder $fh;
        public Bitmap mBitmap;
        public String mKey;

        public BitmapEntry() {
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

        public Bitmap getBitmap() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return this.mBitmap;
            }
            return (Bitmap) invokeV.objValue;
        }

        public String getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.mKey;
            }
            return (String) invokeV.objValue;
        }

        public BitmapEntry(@NonNull String str, @NonNull Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, bitmap};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mKey = str;
            this.mBitmap = bitmap;
            int bitmapSizeInBytes = getBitmapSizeInBytes(bitmap);
            if (bitmapSizeInBytes > 262144) {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                double sqrt = Math.sqrt(262144.0d / bitmapSizeInBytes);
                int i3 = (int) (width * sqrt);
                int i4 = (int) (height * sqrt);
                Log.i("MediaMetadata", "Scaling large bitmap of " + width + "x" + height + " into " + i3 + "x" + i4);
                this.mBitmap = Bitmap.createScaledBitmap(bitmap, i3, i4, true);
            }
        }

        private int getBitmapSizeInBytes(Bitmap bitmap) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, bitmap)) == null) {
                if (Build.VERSION.SDK_INT >= 19) {
                    return bitmap.getAllocationByteCount();
                }
                return bitmap.getByteCount();
            }
            return invokeL.intValue;
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {
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

        @NonNull
        public MediaMetadata build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new MediaMetadata(this.mBundle);
            }
            return (MediaMetadata) invokeV.objValue;
        }

        public Builder(Bundle bundle) {
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
            this.mBundle = new Bundle(bundle);
        }

        public Builder(@NonNull MediaMetadata mediaMetadata) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mediaMetadata};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mBundle = new Bundle(mediaMetadata.mBundle);
        }

        @NonNull
        public Builder putBitmap(@NonNull String str, @Nullable Bitmap bitmap) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, bitmap)) == null) {
                if (str != null) {
                    if (MediaMetadata.METADATA_KEYS_TYPE.containsKey(str) && MediaMetadata.METADATA_KEYS_TYPE.get(str).intValue() != 2) {
                        throw new IllegalArgumentException("The " + str + " key cannot be used to put a Bitmap");
                    }
                    this.mBundle.putParcelable(str, bitmap);
                    return this;
                }
                throw new NullPointerException("key shouldn't be null");
            }
            return (Builder) invokeLL.objValue;
        }

        @NonNull
        public Builder putFloat(@NonNull String str, float f) {
            InterceptResult invokeLF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, str, f)) == null) {
                if (str != null) {
                    if (MediaMetadata.METADATA_KEYS_TYPE.containsKey(str) && MediaMetadata.METADATA_KEYS_TYPE.get(str).intValue() != 4) {
                        throw new IllegalArgumentException("The " + str + " key cannot be used to put a float");
                    }
                    this.mBundle.putFloat(str, f);
                    return this;
                }
                throw new NullPointerException("key shouldn't be null");
            }
            return (Builder) invokeLF.objValue;
        }

        @NonNull
        public Builder putLong(@NonNull String str, long j) {
            InterceptResult invokeLJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048579, this, str, j)) == null) {
                if (str != null) {
                    if (MediaMetadata.METADATA_KEYS_TYPE.containsKey(str) && MediaMetadata.METADATA_KEYS_TYPE.get(str).intValue() != 0) {
                        throw new IllegalArgumentException("The " + str + " key cannot be used to put a long");
                    }
                    this.mBundle.putLong(str, j);
                    return this;
                }
                throw new NullPointerException("key shouldn't be null");
            }
            return (Builder) invokeLJ.objValue;
        }

        @NonNull
        public Builder putRating(@NonNull String str, @Nullable Rating rating) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, str, rating)) == null) {
                if (str != null) {
                    if (MediaMetadata.METADATA_KEYS_TYPE.containsKey(str) && MediaMetadata.METADATA_KEYS_TYPE.get(str).intValue() != 3) {
                        throw new IllegalArgumentException("The " + str + " key cannot be used to put a Rating");
                    }
                    ParcelUtils.putVersionedParcelable(this.mBundle, str, rating);
                    return this;
                }
                throw new NullPointerException("key shouldn't be null");
            }
            return (Builder) invokeLL.objValue;
        }

        @NonNull
        public Builder putString(@NonNull String str, @Nullable String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
                if (str != null) {
                    if (MediaMetadata.METADATA_KEYS_TYPE.containsKey(str) && MediaMetadata.METADATA_KEYS_TYPE.get(str).intValue() != 1) {
                        throw new IllegalArgumentException("The " + str + " key cannot be used to put a String");
                    }
                    this.mBundle.putCharSequence(str, str2);
                    return this;
                }
                throw new NullPointerException("key shouldn't be null");
            }
            return (Builder) invokeLL.objValue;
        }

        @NonNull
        public Builder putText(@NonNull String str, @Nullable CharSequence charSequence) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, str, charSequence)) == null) {
                if (str != null) {
                    if (MediaMetadata.METADATA_KEYS_TYPE.containsKey(str) && MediaMetadata.METADATA_KEYS_TYPE.get(str).intValue() != 1) {
                        throw new IllegalArgumentException("The " + str + " key cannot be used to put a CharSequence");
                    }
                    this.mBundle.putCharSequence(str, charSequence);
                    return this;
                }
                throw new NullPointerException("key shouldn't be null");
            }
            return (Builder) invokeLL.objValue;
        }

        @NonNull
        public Builder setExtras(@Nullable Bundle bundle) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, bundle)) == null) {
                this.mBundle.putBundle(MediaMetadata.METADATA_KEY_EXTRAS, bundle);
                return this;
            }
            return (Builder) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-864780987, "Landroidx/media2/common/MediaMetadata;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-864780987, "Landroidx/media2/common/MediaMetadata;");
                return;
            }
        }
        ArrayMap<String, Integer> arrayMap = new ArrayMap<>();
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
        METADATA_KEYS_TYPE.put("android.media.metadata.MEDIA_URI", 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_RADIO_FREQUENCY, 4);
        METADATA_KEYS_TYPE.put(METADATA_KEY_RADIO_PROGRAM_NAME, 1);
        METADATA_KEYS_TYPE.put(METADATA_KEY_BROWSABLE, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_PLAYABLE, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_ADVERTISEMENT, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        METADATA_KEYS_TYPE.put(METADATA_KEY_EXTRAS, 5);
    }

    public MediaMetadata() {
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

    @Nullable
    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                return this.mBundle.getBundle(METADATA_KEY_EXTRAS);
            } catch (Exception unused) {
                Log.w("MediaMetadata", "Failed to retrieve an extra");
                return null;
            }
        }
        return (Bundle) invokeV.objValue;
    }

    @Nullable
    public String getMediaId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return getString("android.media.metadata.MEDIA_ID");
        }
        return (String) invokeV.objValue;
    }

    @NonNull
    public Set<String> keySet() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.mBundle.size();
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.mBundle.toString();
        }
        return (String) invokeV.objValue;
    }

    public MediaMetadata(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        Bundle bundle2 = new Bundle(bundle);
        this.mBundle = bundle2;
        bundle2.setClassLoader(MediaMetadata.class.getClassLoader());
    }

    public boolean containsKey(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str != null) {
                return this.mBundle.containsKey(str);
            }
            throw new NullPointerException("key shouldn't be null");
        }
        return invokeL.booleanValue;
    }

    @Nullable
    public Bitmap getBitmap(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str != null) {
                try {
                    return (Bitmap) this.mBundle.getParcelable(str);
                } catch (Exception e) {
                    Log.w("MediaMetadata", "Failed to retrieve a key as Bitmap.", e);
                    return null;
                }
            }
            throw new NullPointerException("key shouldn't be null");
        }
        return (Bitmap) invokeL.objValue;
    }

    public float getFloat(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (str != null) {
                return this.mBundle.getFloat(str);
            }
            throw new NullPointerException("key shouldn't be null");
        }
        return invokeL.floatValue;
    }

    public long getLong(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str != null) {
                return this.mBundle.getLong(str, 0L);
            }
            throw new NullPointerException("key shouldn't be null");
        }
        return invokeL.longValue;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Object getObject(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (str != null) {
                return this.mBundle.get(str);
            }
            throw new NullPointerException("key shouldn't be null");
        }
        return invokeL.objValue;
    }

    @Nullable
    public Rating getRating(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (str != null) {
                try {
                    return (Rating) ParcelUtils.getVersionedParcelable(this.mBundle, str);
                } catch (Exception e) {
                    Log.w("MediaMetadata", "Failed to retrieve a key as Rating.", e);
                    return null;
                }
            }
            throw new NullPointerException("key shouldn't be null");
        }
        return (Rating) invokeL.objValue;
    }

    @Nullable
    public String getString(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (str != null) {
                CharSequence charSequence = this.mBundle.getCharSequence(str);
                if (charSequence != null) {
                    return charSequence.toString();
                }
                return null;
            }
            throw new NullPointerException("key shouldn't be null");
        }
        return (String) invokeL.objValue;
    }

    @Nullable
    public CharSequence getText(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, str)) == null) {
            if (str != null) {
                return this.mBundle.getCharSequence(str);
            }
            throw new NullPointerException("key shouldn't be null");
        }
        return (CharSequence) invokeL.objValue;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPostParceling() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            Bundle bundle = this.mParcelableWithoutBitmapBundle;
            if (bundle == null) {
                bundle = new Bundle();
            }
            this.mBundle = bundle;
            ParcelImplListSlice parcelImplListSlice = this.mBitmapListSlice;
            if (parcelImplListSlice != null) {
                for (ParcelImpl parcelImpl : parcelImplListSlice.getList()) {
                    BitmapEntry bitmapEntry = (BitmapEntry) MediaParcelUtils.fromParcelable(parcelImpl);
                    this.mBundle.putParcelable(bitmapEntry.getKey(), bitmapEntry.getBitmap());
                }
            }
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void onPreParceling(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048588, this, z) == null) {
            synchronized (this.mBundle) {
                if (this.mParcelableWithoutBitmapBundle == null) {
                    this.mParcelableWithoutBitmapBundle = new Bundle(this.mBundle);
                    ArrayList arrayList = new ArrayList();
                    for (String str : this.mBundle.keySet()) {
                        Object obj = this.mBundle.get(str);
                        if (obj instanceof Bitmap) {
                            arrayList.add(MediaParcelUtils.toParcelable(new BitmapEntry(str, (Bitmap) obj)));
                            this.mParcelableWithoutBitmapBundle.remove(str);
                        }
                    }
                    this.mBitmapListSlice = new ParcelImplListSlice(arrayList);
                }
            }
        }
    }
}
