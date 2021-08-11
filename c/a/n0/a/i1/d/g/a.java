package c.a.n0.a.i1.d.g;

import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.text.TextUtils;
import c.a.n0.a.i1.d.c.c;
import c.a.n0.a.i1.d.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.media.chooser.model.ImageModel;
import com.baidu.swan.apps.media.chooser.model.MediaModel;
import com.baidu.swan.apps.media.chooser.model.VideoModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<c.a.n0.a.i1.d.f.a> f6486e;

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<MediaModel> f6487f;

    /* renamed from: g  reason: collision with root package name */
    public String f6488g;

    /* renamed from: h  reason: collision with root package name */
    public Handler f6489h;

    public a(String str, Handler handler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, handler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f6486e = new ArrayList<>();
        this.f6487f = new ArrayList<>();
        this.f6488g = str;
        this.f6489h = handler;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.equals(this.f6488g, "video")) {
            return;
        }
        Cursor cursor = null;
        try {
            try {
                cursor = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_added DESC");
            } catch (Exception e2) {
                if (c.f6456a) {
                    e2.printStackTrace();
                }
            }
            if (cursor == null) {
                return;
            }
            while (cursor.moveToNext()) {
                String string = cursor.getString(cursor.getColumnIndex("_data"));
                long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                long j3 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                File file = new File(string);
                if (file.exists() && (c.f6459d || !d.d(string))) {
                    ImageModel imageModel = new ImageModel(string);
                    imageModel.setAddDate(j2);
                    imageModel.setSize(j3);
                    d(file, imageModel);
                }
            }
        } finally {
            c.a.n0.t.d.d(null);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:50:0x00e3 */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
        if (r11 != null) goto L30;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0, types: [c.a.n0.a.i1.d.g.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b() {
        Throwable th;
        Cursor cursor;
        Exception e2;
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ?? r1 = "Image";
            if (TextUtils.equals(this.f6488g, "Image")) {
                return;
            }
            try {
                try {
                    cursor = AppRuntime.getAppContext().getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, null, null, null, "date_added DESC");
                } catch (Throwable th3) {
                    th = th3;
                    c.a.n0.t.d.d(r1);
                    throw th;
                }
            } catch (Exception e3) {
                cursor = null;
                e2 = e3;
            } catch (Throwable th4) {
                r1 = 0;
                th = th4;
                c.a.n0.t.d.d(r1);
                throw th;
            }
            if (cursor == null) {
                c.a.n0.t.d.d(cursor);
                return;
            }
            while (cursor.moveToNext()) {
                try {
                    String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                    long j2 = cursor.getLong(cursor.getColumnIndexOrThrow("date_added"));
                    long j3 = cursor.getInt(cursor.getColumnIndexOrThrow("duration"));
                    long j4 = cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                    int i2 = cursor.getInt(cursor.getColumnIndexOrThrow("width"));
                    int i3 = cursor.getInt(cursor.getColumnIndexOrThrow("height"));
                    if (i2 <= 0 || i3 <= 0) {
                        try {
                            mediaMetadataRetriever = new MediaMetadataRetriever();
                            try {
                                try {
                                    mediaMetadataRetriever.setDataSource(string);
                                    String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                                    String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                                    i2 = Integer.parseInt(extractMetadata);
                                    i3 = Integer.parseInt(extractMetadata2);
                                } catch (Exception e4) {
                                    e = e4;
                                    if (c.f6456a) {
                                        e.printStackTrace();
                                    }
                                }
                            } catch (Throwable th5) {
                                th2 = th5;
                                if (mediaMetadataRetriever != null) {
                                    mediaMetadataRetriever.release();
                                }
                                throw th2;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            mediaMetadataRetriever = null;
                        } catch (Throwable th6) {
                            mediaMetadataRetriever = null;
                            th2 = th6;
                        }
                        mediaMetadataRetriever.release();
                    }
                    File file = new File(string);
                    if (file.exists()) {
                        VideoModel videoModel = new VideoModel(string);
                        videoModel.setAddDate(j2);
                        videoModel.setDuration(j3);
                        videoModel.setSize(j4);
                        videoModel.setWidth(i2);
                        videoModel.setHeight(i3);
                        d(file, videoModel);
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    if (c.f6456a) {
                        e2.printStackTrace();
                    }
                    c.a.n0.t.d.d(cursor);
                }
            }
            c.a.n0.t.d.d(cursor);
        }
    }

    public final void c(ArrayList<c.a.n0.a.i1.d.f.a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, arrayList) == null) {
            Iterator<c.a.n0.a.i1.d.f.a> it = arrayList.iterator();
            while (it.hasNext()) {
                c.a.n0.a.i1.d.f.a next = it.next();
                next.i(new File(next.b()).lastModified());
            }
            Collections.sort(arrayList);
        }
    }

    public final void d(File file, MediaModel mediaModel) {
        String name;
        String path;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, file, mediaModel) == null) {
            if (file.getParentFile() != null) {
                name = file.getParentFile().getName();
                path = file.getParent();
            } else {
                name = file.getName();
                path = file.getPath();
            }
            c.a.n0.a.i1.d.f.a aVar = new c.a.n0.a.i1.d.f.a();
            aVar.h(name);
            aVar.g(path);
            int indexOf = this.f6486e.indexOf(aVar);
            if (indexOf >= 0) {
                this.f6486e.get(indexOf).a(mediaModel);
            } else {
                aVar.a(mediaModel);
                this.f6486e.add(aVar);
            }
            this.f6487f.add(mediaModel);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            a();
            b();
            c(this.f6486e);
            c.a.n0.a.i1.d.f.a aVar = new c.a.n0.a.i1.d.f.a();
            aVar.h(d.b(AppRuntime.getAppContext(), this.f6488g));
            aVar.f6485h = this.f6487f;
            this.f6486e.add(0, aVar);
            Iterator<c.a.n0.a.i1.d.f.a> it = this.f6486e.iterator();
            while (it.hasNext()) {
                Collections.sort(it.next().f());
            }
            Handler handler = this.f6489h;
            if (handler != null) {
                Message obtainMessage = handler.obtainMessage(0);
                obtainMessage.obj = this.f6486e;
                this.f6489h.sendMessage(obtainMessage);
            }
        }
    }
}
