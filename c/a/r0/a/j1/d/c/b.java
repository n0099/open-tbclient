package c.a.r0.a.j1.d.c;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.hardware.Camera;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.k;
import c.a.r0.a.z2.t0;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcher;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultDispatcherHolder;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.tbadk.browser.newshare.ThreadAchievementShareDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Calendar;
/* loaded from: classes.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.j1.d.d.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f7587b;

        public a(c.a.r0.a.j1.d.d.b bVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f7587b = file;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            InterceptResult invokeLIL;
            c.a.r0.a.j1.d.d.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i2, intent)) == null) {
                if (i2 != -1 || (bVar = this.a) == null) {
                    return true;
                }
                bVar.a(this.f7587b);
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* renamed from: c.a.r0.a.j1.d.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0433b implements ActivityResultConsumer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c.a.r0.a.j1.d.d.b a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f7588b;

        public C0433b(c.a.r0.a.j1.d.d.b bVar, File file) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, file};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
            this.f7588b = file;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityResultConsumer
        public boolean consume(ActivityResultDispatcher activityResultDispatcher, int i2, Intent intent) {
            InterceptResult invokeLIL;
            c.a.r0.a.j1.d.d.b bVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, activityResultDispatcher, i2, intent)) == null) {
                if (i2 != -1 || (bVar = this.a) == null) {
                    return true;
                }
                bVar.a(this.f7588b);
                return true;
            }
            return invokeLIL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2129642559, "Lc/a/r0/a/j1/d/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2129642559, "Lc/a/r0/a/j1/d/c/b;");
                return;
            }
        }
        a = k.a;
    }

    public static File a(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            String x = c.a.r0.a.o2.b.x(str);
            File file = new File(x + File.separator + "IMG_" + Calendar.getInstance().getTimeInMillis() + ThreadAchievementShareDialogView.THREAD_IMG_SUFFIX);
            c.a.r0.w.d.h(file);
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static File b(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String x = c.a.r0.a.o2.b.x(str);
            File file = new File(x + File.separator + "VID_" + Calendar.getInstance().getTimeInMillis() + ".mp4");
            c.a.r0.w.d.h(file);
            return file;
        }
        return (File) invokeL.objValue;
    }

    public static VideoModel c(File file) {
        InterceptResult invokeL;
        MediaMetadataRetriever mediaMetadataRetriever;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, file)) == null) {
            String absolutePath = file.getAbsolutePath();
            VideoModel videoModel = new VideoModel(absolutePath);
            MediaMetadataRetriever mediaMetadataRetriever2 = null;
            try {
                try {
                    mediaMetadataRetriever = new MediaMetadataRetriever();
                } catch (Exception e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                mediaMetadataRetriever.setDataSource(absolutePath);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                String extractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                videoModel.setWidth(Integer.parseInt(extractMetadata));
                videoModel.setHeight(Integer.parseInt(extractMetadata2));
                videoModel.setDuration(Long.parseLong(extractMetadata3));
                videoModel.setSize(file.length());
                mediaMetadataRetriever.release();
            } catch (Exception e3) {
                e = e3;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (c.a) {
                    e.printStackTrace();
                }
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                }
                return videoModel;
            } catch (Throwable th2) {
                th = th2;
                mediaMetadataRetriever2 = mediaMetadataRetriever;
                if (mediaMetadataRetriever2 != null) {
                    mediaMetadataRetriever2.release();
                }
                throw th;
            }
            return videoModel;
        }
        return (VideoModel) invokeL.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            int numberOfCameras = Camera.getNumberOfCameras();
            for (int i2 = 0; i2 < numberOfCameras; i2++) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (1 == cameraInfo.facing) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [int, boolean] */
    public static void e(Activity activity, String str, int i2, boolean z, c.a.r0.a.j1.d.d.b bVar) {
        ActivityResultDispatcher resultDispatcher;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{activity, str, Integer.valueOf(i2), Boolean.valueOf(z), bVar}) == null) || (resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher()) == null) {
            return;
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        File b2 = b(str);
        if (c.a.r0.a.z2.d.i()) {
            fromFile = t0.a(activity, b2);
            intent.setFlags(3);
        } else {
            fromFile = Uri.fromFile(b2);
        }
        intent.putExtra("output", fromFile);
        intent.putExtra("android.intent.extra.durationLimit", i2);
        ?? r6 = 1;
        intent.putExtra("android.intent.extra.videoQuality", 1);
        r6 = (z && d()) ? 0 : 0;
        if (c.a.r0.a.z2.d.g()) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", (int) r6);
            intent.putExtra("android.intent.extras.LENS_FACING_FRONT", (int) r6);
            intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", (boolean) r6);
        } else {
            intent.putExtra("android.intent.extras.CAMERA_FACING", (int) r6);
        }
        resultDispatcher.addConsumer(new C0433b(bVar, b2));
        try {
            resultDispatcher.startActivityForResult(intent);
        } catch (ActivityNotFoundException unused) {
            boolean z2 = a;
        }
    }

    public static void f(Activity activity, String str, c.a.r0.a.j1.d.d.b bVar) {
        ActivityResultDispatcher resultDispatcher;
        Uri fromFile;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, activity, str, bVar) == null) || (resultDispatcher = ((ActivityResultDispatcherHolder) activity).getResultDispatcher()) == null) {
            return;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            File a2 = a(str);
            if (a2 == null || !a2.exists()) {
                if (bVar != null) {
                    bVar.b("error create file");
                    return;
                }
                return;
            }
            if (c.a.r0.a.z2.d.i()) {
                fromFile = t0.a(activity, a2);
                intent.setFlags(3);
            } else {
                fromFile = Uri.fromFile(a2);
            }
            intent.putExtra("output", fromFile);
            resultDispatcher.addConsumer(new a(bVar, a2));
            try {
                resultDispatcher.startActivityForResult(intent);
            } catch (ActivityNotFoundException unused) {
                boolean z = a;
            }
        }
    }
}
