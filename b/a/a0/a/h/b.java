package b.a.a0.a.h;

import android.text.TextUtils;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b extends i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f1168a;

        /* renamed from: b  reason: collision with root package name */
        public String f1169b;

        /* renamed from: c  reason: collision with root package name */
        public String f1170c;

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

        public static a a(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    a aVar = new a();
                    aVar.f1168a = jSONObject.optString("name");
                    aVar.f1169b = jSONObject.optString("path");
                    aVar.f1170c = jSONObject.optString(PackageTable.MD5);
                    return aVar;
                } catch (Exception unused) {
                    return null;
                }
            }
            return (a) invokeL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(cVar.f1172b, cVar.f1177g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (File) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static boolean t(File file) {
        InterceptResult invokeL;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            try {
                file2 = new File(file, "files.json");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (file2.exists()) {
                FileInputStream fileInputStream = new FileInputStream(file2);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String str = new String(bArr);
                fileInputStream.close();
                JSONArray optJSONArray = new JSONObject(str).optJSONArray(com.baidu.fsg.face.base.b.c.f37774g);
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    int length = optJSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        arrayList.add(a.a(optJSONArray.getString(i2)));
                    }
                    return u(file, arrayList);
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean u(File file, ArrayList<a> arrayList) {
        InterceptResult invokeLL;
        File file2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, file, arrayList)) == null) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            try {
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    a next = it.next();
                    String str = next.f1169b;
                    if (TextUtils.isEmpty(str)) {
                        file2 = new File(file, next.f1168a);
                    } else {
                        file2 = new File(file, str + File.separator + next.f1168a);
                    }
                    if (!file2.exists()) {
                        return false;
                    }
                    String a2 = e.a(file2.getAbsolutePath());
                    boolean equals = TextUtils.equals(a2, next.f1170c);
                    if (!equals) {
                        i.j(equals + " " + a2 + "!=" + next.f1170c + StringUtil.ARRAY_ELEMENT_SEPARATOR + file2.getAbsolutePath());
                        return false;
                    }
                }
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    @Override // b.a.a0.a.h.i
    public boolean i(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) ? t(file) : invokeL.booleanValue;
    }
}
