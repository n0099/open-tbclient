package c.a.q0.s.f;

import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import c.a.e.e.p.m;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile SQLiteDatabase f24251a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            synchronized (h.class) {
                m.b(f24251a);
            }
        }
    }

    public static synchronized SQLiteDatabase b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (h.class) {
                try {
                } catch (Exception e2) {
                    TiebaStatic.printDBExceptionLog(e2, "RelationshipDbManager.getRelationshipDataBase", new Object[0]);
                }
                if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
                    return null;
                }
                if (f24251a != null && f24251a.isOpen()) {
                    return f24251a;
                }
                f24251a = new g(TbadkCoreApplication.getInst().getApp()).getWritableDatabase();
                return f24251a;
            }
        }
        return (SQLiteDatabase) invokeV.objValue;
    }
}
