package androidx.media2.session;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import androidx.media.AudioAttributesCompat;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.MediaParcelUtils;
import androidx.media2.common.ParcelImplListSlice;
import androidx.media2.common.Rating;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import androidx.media2.session.MediaController;
import androidx.media2.session.MediaLibraryService;
import androidx.media2.session.MediaSession;
import androidx.media2.session.SessionCommandGroup;
import androidx.versionedparcelable.ParcelImpl;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes.dex */
public class MediaUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CURRENT_VERSION = 0;
    public static final Executor DIRECT_EXECUTOR;
    public static final Map<String, String> METADATA_COMPAT_KEY_TO_METADATA_KEY;
    public static final Map<String, String> METADATA_KEY_TO_METADATA_COMPAT_KEY;
    public static final String TAG = "MediaUtils";
    public static final int TRANSACTION_SIZE_LIMIT_IN_BYTES = 262144;
    public static final int VERSION_0 = 0;
    public static final int VERSION_UNKNOWN = -1;
    public static final MediaBrowserServiceCompat.BrowserRoot sDefaultBrowserRoot;
    public transient /* synthetic */ FieldHolder $fh;

    public static int convertToPlaybackStateCompatState(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65554, null, i, i2)) == null) {
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        return 7;
                    }
                    return i2 != 2 ? 3 : 6;
                }
                return 2;
            }
            return 0;
        }
        return invokeII.intValue;
    }

    public static int toBufferingState(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65567, null, i)) == null) {
            if (i != 3) {
                return i != 6 ? 0 : 2;
            }
            return 3;
        }
        return invokeI.intValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1197129746, "Landroidx/media2/session/MediaUtils;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1197129746, "Landroidx/media2/session/MediaUtils;");
                return;
            }
        }
        sDefaultBrowserRoot = new MediaBrowserServiceCompat.BrowserRoot(MediaLibraryService.SERVICE_INTERFACE, null);
        DIRECT_EXECUTOR = new Executor() { // from class: androidx.media2.session.MediaUtils.1
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

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, runnable) == null) {
                    runnable.run();
                }
            }
        };
        METADATA_COMPAT_KEY_TO_METADATA_KEY = new HashMap();
        METADATA_KEY_TO_METADATA_COMPAT_KEY = new HashMap();
        METADATA_COMPAT_KEY_TO_METADATA_KEY.put(MediaMetadataCompat.METADATA_KEY_ADVERTISEMENT, MediaMetadata.METADATA_KEY_ADVERTISEMENT);
        METADATA_COMPAT_KEY_TO_METADATA_KEY.put(MediaMetadataCompat.METADATA_KEY_BT_FOLDER_TYPE, MediaMetadata.METADATA_KEY_BROWSABLE);
        METADATA_COMPAT_KEY_TO_METADATA_KEY.put(MediaMetadataCompat.METADATA_KEY_DOWNLOAD_STATUS, MediaMetadata.METADATA_KEY_DOWNLOAD_STATUS);
        for (Map.Entry<String, String> entry : METADATA_COMPAT_KEY_TO_METADATA_KEY.entrySet()) {
            if (!METADATA_KEY_TO_METADATA_COMPAT_KEY.containsKey(entry.getValue())) {
                METADATA_KEY_TO_METADATA_COMPAT_KEY.put(entry.getValue(), entry.getKey());
            } else {
                throw new RuntimeException("Shouldn't map to the same value");
            }
        }
    }

    public MediaUtils() {
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

    public static List<ParcelImpl> convertCommandButtonListToParcelImplList(List<MediaSession.CommandButton> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(MediaParcelUtils.toParcelable(list.get(i)));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<MediaItem> convertMediaItemListToMediaItemList(List<MediaBrowserCompat.MediaItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(convertToMediaItem(list.get(i)));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static ParcelImplListSlice convertMediaItemListToParcelImplListSlice(List<MediaItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                MediaItem mediaItem = list.get(i);
                if (mediaItem != null) {
                    arrayList.add(MediaParcelUtils.toParcelable(mediaItem));
                }
            }
            return new ParcelImplListSlice(arrayList);
        }
        return (ParcelImplListSlice) invokeL.objValue;
    }

    public static List<MediaItem> convertParcelImplListSliceToMediaItemList(ParcelImplListSlice parcelImplListSlice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, parcelImplListSlice)) == null) {
            if (parcelImplListSlice == null) {
                return null;
            }
            List<ParcelImpl> list = parcelImplListSlice.getList();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                ParcelImpl parcelImpl = list.get(i);
                if (parcelImpl != null) {
                    arrayList.add((MediaItem) MediaParcelUtils.fromParcelable(parcelImpl));
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static List<MediaItem> convertQueueItemListToMediaItemList(List<MediaSessionCompat.QueueItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                MediaItem convertToMediaItem = convertToMediaItem(list.get(i));
                if (convertToMediaItem != null) {
                    arrayList.add(convertToMediaItem);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static MediaItem convertToMediaItem(MediaBrowserCompat.MediaItem mediaItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, mediaItem)) == null) {
            if (mediaItem == null) {
                return null;
            }
            return new MediaItem.Builder().setMetadata(convertToMediaMetadata(mediaItem.getDescription(), mediaItem.isBrowsable(), mediaItem.isPlayable())).build();
        }
        return (MediaItem) invokeL.objValue;
    }

    @Nullable
    public static List<MediaBrowserCompat.MediaItem> convertToMediaItemList(@Nullable List<MediaItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(convertToMediaItem(list.get(i)));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static MediaMetadata convertToMediaMetadata(CharSequence charSequence) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, charSequence)) == null) {
            if (charSequence == null) {
                return null;
            }
            return new MediaMetadata.Builder().putString("android.media.metadata.TITLE", charSequence.toString()).putLong(MediaMetadata.METADATA_KEY_BROWSABLE, 0L).putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1L).build();
        }
        return (MediaMetadata) invokeL.objValue;
    }

    public static int convertToPlayerState(PlaybackStateCompat playbackStateCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65555, null, playbackStateCompat)) == null) {
            if (playbackStateCompat == null) {
                return 0;
            }
            switch (playbackStateCompat.getState()) {
                case 0:
                    return 0;
                case 1:
                case 2:
                case 6:
                    return 1;
                case 3:
                case 4:
                case 5:
                case 8:
                case 9:
                case 10:
                case 11:
                    return 2;
                case 7:
                default:
                    return 3;
            }
        }
        return invokeL.intValue;
    }

    public static boolean doesBundleHaveCustomParcelable(@NonNull Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65562, null, bundle)) == null) {
            Parcel obtain = Parcel.obtain();
            try {
                obtain.writeBundle(bundle);
                obtain.setDataPosition(0);
                Bundle readBundle = obtain.readBundle(null);
                if (readBundle != null) {
                    readBundle.isEmpty();
                }
                return false;
            } catch (BadParcelableException e) {
                Log.d(TAG, "Custom parcelables are not allowed", e);
                return true;
            } finally {
                obtain.recycle();
            }
        }
        return invokeL.booleanValue;
    }

    public static int getRatingCompatStyle(Rating rating) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65563, null, rating)) == null) {
            if (rating instanceof HeartRating) {
                return 1;
            }
            if (rating instanceof ThumbRating) {
                return 2;
            }
            if (rating instanceof StarRating) {
                int maxStars = ((StarRating) rating).getMaxStars();
                int i = 3;
                if (maxStars != 3) {
                    i = 4;
                    if (maxStars != 4) {
                        i = 5;
                        if (maxStars != 5) {
                            return 0;
                        }
                    }
                }
                return i;
            } else if (rating instanceof PercentageRating) {
                return 6;
            } else {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    @Nullable
    public static <T> List<T> removeNullElements(@Nullable List<T> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65566, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (T t : list) {
                if (t != null) {
                    arrayList.add(t);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static MediaController.PlaybackInfo toPlaybackInfo2(MediaControllerCompat.PlaybackInfo playbackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65568, null, playbackInfo)) == null) {
            return MediaController.PlaybackInfo.createPlaybackInfo(playbackInfo.getPlaybackType(), new AudioAttributesCompat.Builder().setLegacyStreamType(playbackInfo.getAudioAttributes().getLegacyStreamType()).build(), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
        return (MediaController.PlaybackInfo) invokeL.objValue;
    }

    @Nullable
    public static MediaItem upcastForPreparceling(@Nullable MediaItem mediaItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65570, null, mediaItem)) == null) {
            if (mediaItem != null && mediaItem.getClass() != MediaItem.class) {
                return new MediaItem.Builder().setStartPosition(mediaItem.getStartPosition()).setEndPosition(mediaItem.getEndPosition()).setMetadata(mediaItem.getMetadata()).build();
            }
            return mediaItem;
        }
        return (MediaItem) invokeL.objValue;
    }

    @NonNull
    public static List<MediaSession.CommandButton> convertToCustomLayout(@Nullable PlaybackStateCompat playbackStateCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, playbackStateCompat)) == null) {
            ArrayList arrayList = new ArrayList();
            if (playbackStateCompat == null) {
                return arrayList;
            }
            for (PlaybackStateCompat.CustomAction customAction : playbackStateCompat.getCustomActions()) {
                arrayList.add(new MediaSession.CommandButton.Builder().setCommand(new SessionCommand(customAction.getAction(), customAction.getExtras())).setDisplayName(customAction.getName()).setEnabled(true).setIconResId(customAction.getIcon()).build());
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static MediaMetadataCompat convertToMediaMetadataCompat(MediaMetadata mediaMetadata) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65553, null, mediaMetadata)) == null) {
            if (mediaMetadata == null) {
                return null;
            }
            MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder();
            for (String str2 : mediaMetadata.keySet()) {
                if (METADATA_KEY_TO_METADATA_COMPAT_KEY.containsKey(str2)) {
                    str = METADATA_KEY_TO_METADATA_COMPAT_KEY.get(str2);
                } else {
                    str = str2;
                }
                Object object = mediaMetadata.getObject(str2);
                if (object instanceof CharSequence) {
                    builder.putText(str, (CharSequence) object);
                } else if (object instanceof Bitmap) {
                    builder.putBitmap(str, (Bitmap) object);
                } else if (object instanceof Long) {
                    builder.putLong(str, ((Long) object).longValue());
                } else if ((object instanceof Bundle) && !TextUtils.equals(str2, MediaMetadata.METADATA_KEY_EXTRAS)) {
                    try {
                        builder.putRating(str, convertToRatingCompat(mediaMetadata.getRating(str2)));
                    } catch (Exception unused) {
                    }
                }
            }
            return builder.build();
        }
        return (MediaMetadataCompat) invokeL.objValue;
    }

    @SuppressLint({"WrongConstant"})
    public static RatingCompat convertToRatingCompat(Rating rating) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65558, null, rating)) == null) {
            if (rating == null) {
                return null;
            }
            int ratingCompatStyle = getRatingCompatStyle(rating);
            if (!rating.isRated()) {
                return RatingCompat.newUnratedRating(ratingCompatStyle);
            }
            switch (ratingCompatStyle) {
                case 1:
                    return RatingCompat.newHeartRating(((HeartRating) rating).hasHeart());
                case 2:
                    return RatingCompat.newThumbRating(((ThumbRating) rating).isThumbUp());
                case 3:
                case 4:
                case 5:
                    return RatingCompat.newStarRating(ratingCompatStyle, ((StarRating) rating).getStarRating());
                case 6:
                    return RatingCompat.newPercentageRating(((PercentageRating) rating).getPercentRating());
                default:
                    return null;
            }
        }
        return (RatingCompat) invokeL.objValue;
    }

    @Nullable
    public static MediaLibraryService.LibraryParams convertToLibraryParams(@NonNull Context context, @Nullable Bundle bundle) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, context, bundle)) == null) {
            if (bundle == null) {
                return null;
            }
            try {
                bundle.setClassLoader(context.getClassLoader());
                return new MediaLibraryService.LibraryParams.Builder().setExtras(bundle).setRecent(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_RECENT)).setOffline(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_OFFLINE)).setSuggested(bundle.getBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_SUGGESTED)).build();
            } catch (Exception unused) {
                return new MediaLibraryService.LibraryParams.Builder().setExtras(bundle).build();
            }
        }
        return (MediaLibraryService.LibraryParams) invokeLL.objValue;
    }

    public static <T extends Parcelable> List<T> truncateListBySize(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65569, null, list, i)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Parcel obtain = Parcel.obtain();
            for (int i2 = 0; i2 < list.size(); i2++) {
                try {
                    T t = list.get(i2);
                    obtain.writeParcelable(t, 0);
                    if (obtain.dataSize() >= i) {
                        break;
                    }
                    arrayList.add(t);
                } finally {
                    obtain.recycle();
                }
            }
            return arrayList;
        }
        return (List) invokeLI.objValue;
    }

    @Nullable
    public static MediaBrowserCompat.MediaItem convertToMediaItem(@Nullable MediaItem mediaItem) {
        InterceptResult invokeL;
        MediaDescriptionCompat build;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, mediaItem)) == null) {
            if (mediaItem == null) {
                return null;
            }
            MediaMetadata metadata = mediaItem.getMetadata();
            int i2 = 0;
            if (metadata == null) {
                build = new MediaDescriptionCompat.Builder().setMediaId(mediaItem.getMediaId()).build();
            } else {
                MediaDescriptionCompat.Builder extras = new MediaDescriptionCompat.Builder().setMediaId(mediaItem.getMediaId()).setSubtitle(metadata.getText("android.media.metadata.DISPLAY_SUBTITLE")).setDescription(metadata.getText("android.media.metadata.DISPLAY_DESCRIPTION")).setIconBitmap(metadata.getBitmap("android.media.metadata.DISPLAY_ICON")).setExtras(metadata.getExtras());
                String string = metadata.getString("android.media.metadata.TITLE");
                if (string != null) {
                    extras.setTitle(string);
                } else {
                    extras.setTitle(metadata.getString("android.media.metadata.DISPLAY_TITLE"));
                }
                String string2 = metadata.getString("android.media.metadata.DISPLAY_ICON_URI");
                if (string2 != null) {
                    extras.setIconUri(Uri.parse(string2));
                }
                String string3 = metadata.getString("android.media.metadata.MEDIA_URI");
                if (string3 != null) {
                    extras.setMediaUri(Uri.parse(string3));
                }
                build = extras.build();
                boolean z = true;
                if (metadata.containsKey(MediaMetadata.METADATA_KEY_BROWSABLE) && metadata.getLong(MediaMetadata.METADATA_KEY_BROWSABLE) != -1) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (metadata.getLong(MediaMetadata.METADATA_KEY_PLAYABLE) == 0) {
                    z = false;
                }
                if (z) {
                    i2 = 2;
                }
                i2 |= i;
            }
            return new MediaBrowserCompat.MediaItem(build, i2);
        }
        return (MediaBrowserCompat.MediaItem) invokeL.objValue;
    }

    public static MediaItem convertToMediaItem(MediaDescriptionCompat mediaDescriptionCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, mediaDescriptionCompat)) == null) {
            MediaMetadata convertToMediaMetadata = convertToMediaMetadata(mediaDescriptionCompat, false, true);
            if (convertToMediaMetadata == null) {
                return null;
            }
            return new MediaItem.Builder().setMetadata(convertToMediaMetadata).build();
        }
        return (MediaItem) invokeL.objValue;
    }

    public static MediaDescriptionCompat createMediaDescriptionCompat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new MediaDescriptionCompat.Builder().setMediaId(str).build();
        }
        return (MediaDescriptionCompat) invokeL.objValue;
    }

    public static boolean isUnparcelableBundle(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65564, null, bundle)) == null) {
            if (bundle == null) {
                return false;
            }
            bundle.setClassLoader(MediaUtils.class.getClassLoader());
            try {
                bundle.size();
                return false;
            } catch (Exception unused) {
                return true;
            }
        }
        return invokeL.booleanValue;
    }

    public static void keepUnparcelableBundlesOnly(List<Bundle> list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65565, null, list) != null) || list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            if (isUnparcelableBundle(list.get(size))) {
                list.remove(size);
            }
        }
    }

    @Nullable
    public static VideoSize upcastForPreparceling(@Nullable VideoSize videoSize) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65572, null, videoSize)) == null) {
            if (videoSize != null && videoSize.getClass() != VideoSize.class) {
                return new VideoSize(videoSize.getWidth(), videoSize.getHeight());
            }
            return videoSize;
        }
        return (VideoSize) invokeL.objValue;
    }

    public static MediaItem convertToMediaItem(MediaMetadataCompat mediaMetadataCompat) {
        InterceptResult invokeL;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, mediaMetadataCompat)) == null) {
            if (mediaMetadataCompat == null) {
                return null;
            }
            MediaMetadata.Builder putLong = new MediaMetadata.Builder().putLong(MediaMetadata.METADATA_KEY_PLAYABLE, 1L);
            for (String str2 : mediaMetadataCompat.keySet()) {
                Object obj = mediaMetadataCompat.getBundle().get(str2);
                if (METADATA_COMPAT_KEY_TO_METADATA_KEY.containsKey(str2)) {
                    str = METADATA_COMPAT_KEY_TO_METADATA_KEY.get(str2);
                } else {
                    str = str2;
                }
                if (obj instanceof CharSequence) {
                    putLong.putText(str, (CharSequence) obj);
                } else if (obj instanceof Bitmap) {
                    putLong.putBitmap(str, (Bitmap) obj);
                } else if (obj instanceof Long) {
                    putLong.putLong(str, ((Long) obj).longValue());
                } else if ((obj instanceof RatingCompat) || (Build.VERSION.SDK_INT >= 19 && (obj instanceof android.media.Rating))) {
                    try {
                        putLong.putRating(str, convertToRating(mediaMetadataCompat.getRating(str2)));
                    } catch (Exception unused) {
                    }
                }
            }
            return new MediaItem.Builder().setMetadata(putLong.build()).build();
        }
        return (MediaItem) invokeL.objValue;
    }

    public static Rating convertToRating(RatingCompat ratingCompat) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, ratingCompat)) == null) {
            if (ratingCompat == null) {
                return null;
            }
            switch (ratingCompat.getRatingStyle()) {
                case 1:
                    if (ratingCompat.isRated()) {
                        return new HeartRating(ratingCompat.hasHeart());
                    }
                    return new HeartRating();
                case 2:
                    if (ratingCompat.isRated()) {
                        return new ThumbRating(ratingCompat.isThumbUp());
                    }
                    return new ThumbRating();
                case 3:
                    if (ratingCompat.isRated()) {
                        return new StarRating(3, ratingCompat.getStarRating());
                    }
                    return new StarRating(3);
                case 4:
                    if (ratingCompat.isRated()) {
                        return new StarRating(4, ratingCompat.getStarRating());
                    }
                    return new StarRating(4);
                case 5:
                    if (ratingCompat.isRated()) {
                        return new StarRating(5, ratingCompat.getStarRating());
                    }
                    return new StarRating(5);
                case 6:
                    if (ratingCompat.isRated()) {
                        return new PercentageRating(ratingCompat.getPercentRating());
                    }
                    return new PercentageRating();
                default:
                    return null;
            }
        }
        return (Rating) invokeL.objValue;
    }

    public static MediaItem convertToMediaItem(MediaSessionCompat.QueueItem queueItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, queueItem)) == null) {
            if (queueItem == null) {
                return null;
            }
            return new MediaItem.Builder().setMetadata(convertToMediaMetadata(queueItem.getDescription(), false, true)).build();
        }
        return (MediaItem) invokeL.objValue;
    }

    public static MediaMetadata convertToMediaMetadata(MediaDescriptionCompat mediaDescriptionCompat, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65551, null, new Object[]{mediaDescriptionCompat, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            if (mediaDescriptionCompat == null) {
                return null;
            }
            MediaMetadata.Builder builder = new MediaMetadata.Builder();
            builder.putString("android.media.metadata.MEDIA_ID", mediaDescriptionCompat.getMediaId());
            CharSequence title = mediaDescriptionCompat.getTitle();
            if (title != null) {
                builder.putText("android.media.metadata.DISPLAY_TITLE", title);
            }
            if (mediaDescriptionCompat.getDescription() != null) {
                builder.putText("android.media.metadata.DISPLAY_DESCRIPTION", mediaDescriptionCompat.getDescription());
            }
            CharSequence subtitle = mediaDescriptionCompat.getSubtitle();
            if (subtitle != null) {
                builder.putText("android.media.metadata.DISPLAY_SUBTITLE", subtitle);
            }
            Bitmap iconBitmap = mediaDescriptionCompat.getIconBitmap();
            if (iconBitmap != null) {
                builder.putBitmap("android.media.metadata.DISPLAY_ICON", iconBitmap);
            }
            Uri iconUri = mediaDescriptionCompat.getIconUri();
            if (iconUri != null) {
                builder.putText("android.media.metadata.DISPLAY_ICON_URI", iconUri.toString());
            }
            Bundle extras = mediaDescriptionCompat.getExtras();
            if (extras != null) {
                builder.setExtras(extras);
            }
            Uri mediaUri = mediaDescriptionCompat.getMediaUri();
            if (mediaUri != null) {
                builder.putText("android.media.metadata.MEDIA_URI", mediaUri.toString());
            }
            long j = 0;
            if (extras != null && extras.containsKey(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE)) {
                builder.putLong(MediaMetadata.METADATA_KEY_BROWSABLE, extras.getLong(MediaDescriptionCompat.EXTRA_BT_FOLDER_TYPE));
            } else if (z) {
                builder.putLong(MediaMetadata.METADATA_KEY_BROWSABLE, 0L);
            } else {
                builder.putLong(MediaMetadata.METADATA_KEY_BROWSABLE, -1L);
            }
            if (z2) {
                j = 1;
            }
            builder.putLong(MediaMetadata.METADATA_KEY_PLAYABLE, j);
            return builder.build();
        }
        return (MediaMetadata) invokeCommon.objValue;
    }

    public static List<MediaSessionCompat.QueueItem> convertToQueueItemList(List<MediaItem> list) {
        InterceptResult invokeL;
        MediaDescriptionCompat description;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65556, null, list)) == null) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                MediaItem mediaItem = list.get(i);
                if (mediaItem.getMetadata() == null) {
                    description = new MediaDescriptionCompat.Builder().setMediaId(mediaItem.getMediaId()).build();
                } else {
                    description = convertToMediaMetadataCompat(mediaItem.getMetadata()).getDescription();
                }
                arrayList.add(new MediaSessionCompat.QueueItem(description, i));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    @Nullable
    public static Bundle convertToRootHints(@Nullable MediaLibraryService.LibraryParams libraryParams) {
        InterceptResult invokeL;
        Bundle bundle;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65559, null, libraryParams)) == null) {
            if (libraryParams == null) {
                return null;
            }
            if (libraryParams.getExtras() == null) {
                bundle = new Bundle();
            } else {
                bundle = new Bundle(libraryParams.getExtras());
            }
            bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_RECENT, libraryParams.isRecent());
            bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_OFFLINE, libraryParams.isOffline());
            bundle.putBoolean(MediaBrowserServiceCompat.BrowserRoot.EXTRA_SUGGESTED, libraryParams.isSuggested());
            return bundle;
        }
        return (Bundle) invokeL.objValue;
    }

    @NonNull
    public static SessionCommandGroup convertToSessionCommandGroup(long j, @Nullable PlaybackStateCompat playbackStateCompat) {
        InterceptResult invokeJL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(65560, null, j, playbackStateCompat)) == null) {
            SessionCommandGroup.Builder builder = new SessionCommandGroup.Builder();
            builder.addAllPlayerBasicCommands(1);
            if ((j & 4) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                builder.addAllPlayerPlaylistCommands(1);
            }
            builder.addAllVolumeCommands(1);
            builder.addAllSessionCommands(1);
            builder.removeCommand(new SessionCommand(10004));
            builder.removeCommand(new SessionCommand(11000));
            builder.removeCommand(new SessionCommand(11001));
            builder.removeCommand(new SessionCommand(11002));
            if (playbackStateCompat != null && playbackStateCompat.getCustomActions() != null) {
                for (PlaybackStateCompat.CustomAction customAction : playbackStateCompat.getCustomActions()) {
                    builder.addCommand(new SessionCommand(customAction.getAction(), customAction.getExtras()));
                }
            }
            return builder.build();
        }
        return (SessionCommandGroup) invokeJL.objValue;
    }

    @Nullable
    public static SessionPlayer.TrackInfo upcastForPreparceling(@Nullable SessionPlayer.TrackInfo trackInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65571, null, trackInfo)) == null) {
            if (trackInfo != null && trackInfo.getClass() != SessionPlayer.TrackInfo.class) {
                return new SessionPlayer.TrackInfo(trackInfo.getId(), trackInfo.getTrackType(), trackInfo.getFormat(), trackInfo.isSelectable());
            }
            return trackInfo;
        }
        return (SessionPlayer.TrackInfo) invokeL.objValue;
    }

    @Nullable
    public static List<SessionPlayer.TrackInfo> upcastForPreparceling(@Nullable List<SessionPlayer.TrackInfo> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65573, null, list)) == null) {
            if (list == null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                arrayList.add(upcastForPreparceling(list.get(i)));
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
