package androidx.media2.session;

import android.view.Surface;
import androidx.media2.common.MediaItem;
import androidx.media2.common.MediaMetadata;
import androidx.media2.common.SessionPlayer;
import androidx.media2.common.VideoSize;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
/* loaded from: classes.dex */
public class MediaInterface {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public interface SessionPlaybackControl {
        long getBufferedPosition();

        int getBufferingState();

        long getCurrentPosition();

        long getDuration();

        float getPlaybackSpeed();

        int getPlayerState();

        ListenableFuture pause();

        ListenableFuture play();

        ListenableFuture prepare();

        ListenableFuture seekTo(long j);

        ListenableFuture setPlaybackSpeed(float f);
    }

    /* loaded from: classes.dex */
    public interface SessionPlayer extends SessionPlaybackControl, SessionPlaylistControl {
        ListenableFuture deselectTrack(SessionPlayer.TrackInfo trackInfo);

        SessionPlayer.TrackInfo getSelectedTrack(int i);

        List getTracks();

        VideoSize getVideoSize();

        ListenableFuture selectTrack(SessionPlayer.TrackInfo trackInfo);

        ListenableFuture setSurface(Surface surface);
    }

    /* loaded from: classes.dex */
    public interface SessionPlaylistControl {
        ListenableFuture addPlaylistItem(int i, MediaItem mediaItem);

        MediaItem getCurrentMediaItem();

        int getCurrentMediaItemIndex();

        int getNextMediaItemIndex();

        List getPlaylist();

        MediaMetadata getPlaylistMetadata();

        int getPreviousMediaItemIndex();

        int getRepeatMode();

        int getShuffleMode();

        ListenableFuture movePlaylistItem(int i, int i2);

        ListenableFuture removePlaylistItem(int i);

        ListenableFuture replacePlaylistItem(int i, MediaItem mediaItem);

        ListenableFuture setMediaItem(MediaItem mediaItem);

        ListenableFuture setPlaylist(List list, MediaMetadata mediaMetadata);

        ListenableFuture setRepeatMode(int i);

        ListenableFuture setShuffleMode(int i);

        ListenableFuture skipToNextItem();

        ListenableFuture skipToPlaylistItem(int i);

        ListenableFuture skipToPreviousItem();

        ListenableFuture updatePlaylistMetadata(MediaMetadata mediaMetadata);
    }

    public MediaInterface() {
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
}
