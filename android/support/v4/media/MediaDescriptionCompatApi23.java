package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import androidx.annotation.RequiresApi;
@RequiresApi(23)
/* loaded from: classes.dex */
public class MediaDescriptionCompatApi23 {

    /* loaded from: classes.dex */
    public static class Builder {
        public static void setMediaUri(Object obj, Uri uri) {
            ((MediaDescription.Builder) obj).setMediaUri(uri);
        }
    }

    public static Uri getMediaUri(Object obj) {
        return ((MediaDescription) obj).getMediaUri();
    }
}
