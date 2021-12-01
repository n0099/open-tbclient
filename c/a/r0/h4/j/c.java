package c.a.r0.h4.j;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.provider.MediaStore;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.down.statistic.ConfigSpeedStat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.r1;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes6.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static final class a implements Comparator<b> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(b bVar, b bVar2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bVar, bVar2)) == null) {
                int i2 = bVar.b() < bVar2.b() ? 1 : 0;
                if (bVar.b() > bVar2.b()) {
                    return -1;
                }
                return i2;
            }
            return invokeLL.intValue;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00d3, code lost:
        if (r2 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00d5, code lost:
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ec, code lost:
        if (r2 != null) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ef, code lost:
        r15.moveToNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f6, code lost:
        if (r8.d() == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0100, code lost:
        if (r8.a() == 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x010a, code lost:
        if (c(r8.c()) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0114, code lost:
        if (r8.a() < 1000) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0116, code lost:
        r0 = r8.d();
        r2 = r0.substring(r9, r0.lastIndexOf("/"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012a, code lost:
        if (r0.contains("/DCIM/") != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x012c, code lost:
        if (r2 == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0132, code lost:
        if (r2.equals("/sdcard") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x013e, code lost:
        if (new java.io.File(r0).exists() == false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0140, code lost:
        r1.add(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0143, code lost:
        r5 = r21 + 1;
        r7 = r17;
        r9 = r18;
        r8 = r22;
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<b> a(Context context) {
        InterceptResult invokeL;
        Cursor cursor;
        Cursor cursor2;
        int i2;
        ContentResolver contentResolver;
        String str;
        int i3;
        b bVar;
        Cursor cursor3;
        ContentResolver contentResolver2;
        String string;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, context)) == null) {
            ArrayList arrayList = new ArrayList();
            ContentResolver contentResolver3 = context.getContentResolver();
            String str2 = "_id";
            try {
                Cursor query = contentResolver3.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{"_id", "_data", "duration", "mime_type", "date_modified"}, null, null, "title");
                try {
                    String[] strArr = {"video_id", "_data"};
                    query.moveToFirst();
                    int count = query.getCount();
                    int i4 = 0;
                    int i5 = 0;
                    while (i5 < count) {
                        b bVar2 = new b();
                        String string2 = query.getString(query.getColumnIndex(str2));
                        bVar2.i(string2);
                        String string3 = query.getString(query.getColumnIndex("_data"));
                        if (string3 != null) {
                            bVar2.j(string3.replace("/storage/emulated/0", "/sdcard"));
                        }
                        int i6 = count;
                        bVar2.e(c.a.d.f.m.b.e(query.getString(query.getColumnIndex("duration")), i4));
                        bVar2.g(query.getString(query.getColumnIndex("mime_type")));
                        bVar2.f(Long.parseLong(query.getString(query.getColumnIndex("date_modified"))));
                        try {
                            try {
                                contentResolver2 = contentResolver3;
                                i2 = i5;
                                contentResolver = contentResolver3;
                                str = str2;
                                i3 = 0;
                                bVar = bVar2;
                            } catch (Exception e2) {
                                e = e2;
                                i2 = i5;
                                contentResolver = contentResolver3;
                                str = str2;
                                i3 = 0;
                                bVar = bVar2;
                            }
                            try {
                                cursor3 = contentResolver2.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, strArr, "video_id=" + string2, null, null);
                                if (cursor3 != null) {
                                    try {
                                        try {
                                            if (cursor3.moveToFirst() && (string = cursor3.getString(cursor3.getColumnIndex("_data"))) != null) {
                                                bVar.h(string.replace("/storage/emulated/0", "/sdcard"));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            cursor2 = cursor3;
                                            if (cursor2 != null) {
                                                cursor2.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e3) {
                                        e = e3;
                                        e.printStackTrace();
                                    }
                                }
                            } catch (Exception e4) {
                                e = e4;
                                cursor3 = null;
                                e.printStackTrace();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = null;
                        }
                    }
                    if (query != null) {
                        query.close();
                    }
                } catch (Exception e5) {
                    e = e5;
                    cursor = query;
                    try {
                        e.printStackTrace();
                        if (cursor != null) {
                            cursor.close();
                        }
                        return arrayList;
                    } catch (Throwable th3) {
                        th = th3;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    cursor = query;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
                cursor = null;
            } catch (Throwable th5) {
                th = th5;
                cursor = null;
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE] complete} */
    public static b b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                b bVar = new b();
                bVar.j(str);
                bVar.f(file.lastModified());
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        try {
                            mediaMetadataRetriever.setDataSource(str);
                            String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                            if (extractMetadata != null) {
                                bVar.e(Integer.parseInt(extractMetadata));
                            }
                            bVar.g(mediaMetadataRetriever.extractMetadata(12));
                            mediaMetadataRetriever.release();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            mediaMetadataRetriever.release();
                        }
                    } catch (Throwable th) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
                return bVar;
            }
            return null;
        }
        return (b) invokeL.objValue;
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? "video/mp4".equals(str) || "video/ext-mp4".equals(str) : invokeL.booleanValue;
    }

    public static void d(String str, List<b> list, boolean z) {
        File[] listFiles;
        b b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLZ(65539, null, str, list, z) == null) || list == null || StringUtils.isNull(str) || (listFiles = new File(str).listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file : listFiles) {
            if (file != null && !StringUtils.isNull(file.getPath())) {
                String path = file.getPath();
                if (file.isFile()) {
                    if (path.contains("_tiebaconverting.mp4")) {
                        if (file.exists()) {
                            file.delete();
                        }
                    } else if (path.contains(".mp4") && ".mp4".equals(path.substring(path.lastIndexOf(".mp4"))) && (b2 = b(file.getPath())) != null && file.length() > ConfigSpeedStat.CFG_MIN_SIZE_DEFAULT && b2.a() >= 1000 && c(b2.c())) {
                        list.add(b2);
                    }
                } else if (file.isDirectory() && !path.contains(r1.f56836k) && z) {
                    d(path, list, z);
                }
            }
        }
    }

    public static void e(List<b> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list) == null) {
            Collections.sort(list, new a());
        }
    }
}
