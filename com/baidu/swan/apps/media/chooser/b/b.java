package com.baidu.swan.apps.media.chooser.b;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import java.io.File;
import java.util.Calendar;
/* loaded from: classes11.dex */
public class b {
    public static void a(Activity activity, String str, final com.baidu.swan.apps.media.chooser.c.b bVar) {
        Uri fromFile;
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher();
        if (resultDispatcher != null) {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            if (intent.resolveActivity(activity.getPackageManager()) != null) {
                final File jf = jf(str);
                if (jf == null || !jf.exists()) {
                    if (bVar != null) {
                        bVar.jd("error create file");
                        return;
                    }
                    return;
                }
                if (com.baidu.swan.apps.as.a.hasNougat()) {
                    fromFile = FileProvider.getUriForFile(activity, activity.getPackageName() + ".swan.fileprovider", jf);
                    intent.setFlags(3);
                } else {
                    fromFile = Uri.fromFile(jf);
                }
                intent.putExtra("output", fromFile);
                resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.apps.media.chooser.b.b.1
                    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                    public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i, Intent intent2) {
                        if (i == -1 && com.baidu.swan.apps.media.chooser.c.b.this != null) {
                            com.baidu.swan.apps.media.chooser.c.b.this.s(jf);
                            return true;
                        }
                        return true;
                    }
                });
                resultDispatcher.startActivityForResult(intent);
            }
        }
    }

    public static void a(Activity activity, String str, int i, boolean z, final com.baidu.swan.apps.media.chooser.c.b bVar) {
        Uri fromFile;
        ActivityResultDispatcher resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher();
        if (resultDispatcher != null) {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            final File jg = jg(str);
            if (com.baidu.swan.apps.as.a.hasNougat()) {
                fromFile = FileProvider.getUriForFile(activity, activity.getPackageName() + ".swan.fileprovider", jg);
                intent.setFlags(3);
            } else {
                fromFile = Uri.fromFile(jg);
            }
            intent.putExtra("output", fromFile);
            intent.putExtra("android.intent.extra.durationLimit", i);
            intent.putExtra("android.intent.extra.videoQuality", 1);
            if (z && XK()) {
                if (com.baidu.swan.apps.as.a.hasLollipopMR1()) {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                    intent.putExtra("android.intent.extras.LENS_FACING_FRONT", 1);
                    intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
                } else {
                    intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
                }
            }
            resultDispatcher.addConsumer(new ActivityResultConsumer() { // from class: com.baidu.swan.apps.media.chooser.b.b.2
                @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
                public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent2) {
                    if (i2 == -1 && com.baidu.swan.apps.media.chooser.c.b.this != null) {
                        com.baidu.swan.apps.media.chooser.c.b.this.s(jg);
                        return true;
                    }
                    return true;
                }
            });
            resultDispatcher.startActivityForResult(intent);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [173=4] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static VideoModel t(File file) {
        MediaMetadataRetriever mediaMetadataRetriever;
        String absolutePath = file.getAbsolutePath();
        VideoModel videoModel = new VideoModel(absolutePath);
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                try {
                    mediaMetadataRetriever.setDataSource(absolutePath);
                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                    String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                    videoModel.setWidth(Integer.parseInt(extractMetadata));
                    videoModel.setHeight(Integer.parseInt(extractMetadata2));
                    videoModel.setDuration(Long.parseLong(extractMetadata3));
                    videoModel.setSize(file.length());
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                } catch (Exception e) {
                    e = e;
                    if (c.DEBUG) {
                        e.printStackTrace();
                    }
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    return videoModel;
                }
            } catch (Throwable th) {
                th = th;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            mediaMetadataRetriever = null;
        } catch (Throwable th2) {
            th = th2;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
            }
            throw th;
        }
        return videoModel;
    }

    private static boolean XK() {
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i, cameraInfo);
            if (1 == cameraInfo.facing) {
                return true;
            }
        }
        return false;
    }

    private static File jf(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.storage.b.lX(str) + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ".jpg");
        com.baidu.swan.d.c.createNewFileSafely(file);
        return file;
    }

    private static File jg(@NonNull String str) {
        File file = new File(com.baidu.swan.apps.storage.b.lX(str) + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4");
        com.baidu.swan.d.c.createNewFileSafely(file);
        return file;
    }
}
