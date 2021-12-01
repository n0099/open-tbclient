package c.a.p0.a.r0;

import android.text.TextUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a implements Comparator<File> {
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
        public int compare(File file, File file2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, file, file2)) == null) ? Long.compare(file.lastModified(), file2.lastModified()) : invokeLL.intValue;
        }
    }

    public static void a() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            String y = n.y(AppRuntime.getAppContext());
            if (TextUtils.isEmpty(y)) {
                return;
            }
            File file = new File(y);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        String str = file2.getAbsolutePath() + File.separator + "aigames/sandbox";
                        File file3 = new File(str);
                        if (file3.exists() && file3.isDirectory()) {
                            String str2 = y + File.separator + "swangame/anonymous/sandbox";
                            if (!file3.renameTo(new File(str2))) {
                                n.e(str, str2);
                                n.j(str);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void b() {
        File[] d2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65537, null) == null) || (d2 = c.a.p0.a.c1.b.m().d()) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : d2) {
            String name = file.getName();
            if (name.startsWith("aigame_storage_") && !name.endsWith("_anonymous.xml")) {
                arrayList.add(file);
            }
        }
        Collections.sort(arrayList, new a());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            File file2 = (File) it.next();
            String absolutePath = file2.getAbsolutePath();
            int lastIndexOf = absolutePath.lastIndexOf("_");
            String str = absolutePath.substring(0, lastIndexOf) + "_anonymous.xml";
            if (!absolutePath.equals(str)) {
                File file3 = new File(str);
                if (file3.exists()) {
                    c.a.p0.w.d.L(file3);
                }
                if (!file2.renameTo(file3)) {
                    c.a.p0.w.d.f(file2, file3);
                    c.a.p0.w.d.L(file2);
                }
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65538, null) == null) && c.a.p0.a.o2.g.h.a().getBoolean("swan_game_data_migration", true)) {
            c.a.p0.a.o2.g.h.a().putBoolean("swan_game_data_migration", false);
            if (c.a.p0.a.b1.a.a) {
                String str = "before migrate " + System.currentTimeMillis();
            }
            a();
            if (c.a.p0.a.b1.a.a) {
                String str2 = "in migrate " + System.currentTimeMillis();
            }
            b();
            if (c.a.p0.a.b1.a.a) {
                String str3 = "end migrate " + System.currentTimeMillis();
            }
        }
    }
}
