package c.a.p0.n.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.bridge.BaiduAppJsBridgeHandler;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes3.dex */
public abstract class b<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public b() {
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

    public ContentValues a(c.a.p0.n.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, eVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_id", eVar.f11893g);
            contentValues.put("category", Integer.valueOf(eVar.f11894h));
            contentValues.put("version_name", eVar.f11896j);
            contentValues.put("version_code", Long.valueOf(eVar.f11895i));
            contentValues.put("size", Long.valueOf(eVar.k));
            contentValues.put(PackageTable.MD5, eVar.l);
            contentValues.put("sign", eVar.m);
            contentValues.put(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL, eVar.n);
            contentValues.put(PackageTable.FILE_PATH, eVar.f11887a);
            contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(eVar.f11888b));
            contentValues.put("create_time", Long.valueOf(eVar.f11889c));
            contentValues.put("update_time", Long.valueOf(eVar.f11890d));
            contentValues.put("state", Integer.valueOf(eVar.f11891e));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean b(Cursor cursor, c.a.p0.n.h.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, eVar)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("bundle_id");
                int columnIndex2 = cursor.getColumnIndex("category");
                int columnIndex3 = cursor.getColumnIndex("version_name");
                int columnIndex4 = cursor.getColumnIndex("version_code");
                int columnIndex5 = cursor.getColumnIndex("size");
                int columnIndex6 = cursor.getColumnIndex(PackageTable.MD5);
                int columnIndex7 = cursor.getColumnIndex("sign");
                int columnIndex8 = cursor.getColumnIndex(BaiduAppJsBridgeHandler.INPUT_PARAM_DOWNLOAD_URL);
                int columnIndex9 = cursor.getColumnIndex("_id");
                int columnIndex10 = cursor.getColumnIndex(PackageTable.FILE_PATH);
                int columnIndex11 = cursor.getColumnIndex(PackageTable.CURRENT_SIZE);
                int columnIndex12 = cursor.getColumnIndex("create_time");
                int columnIndex13 = cursor.getColumnIndex("update_time");
                int columnIndex14 = cursor.getColumnIndex("state");
                String string = cursor.getString(columnIndex);
                if (TextUtils.isEmpty(string)) {
                    return false;
                }
                eVar.f11893g = string;
                eVar.f11894h = cursor.getInt(columnIndex2);
                eVar.f11896j = cursor.getString(columnIndex3);
                eVar.f11895i = cursor.getInt(columnIndex4);
                eVar.k = cursor.getLong(columnIndex5);
                eVar.l = cursor.getString(columnIndex6);
                eVar.m = cursor.getString(columnIndex7);
                eVar.n = cursor.getString(columnIndex8);
                eVar.f11887a = cursor.getString(columnIndex10);
                eVar.f11888b = cursor.getLong(columnIndex11);
                eVar.f11889c = cursor.getLong(columnIndex12);
                eVar.f11890d = cursor.getLong(columnIndex13);
                eVar.f11892f = cursor.getLong(columnIndex9);
                eVar.f11891e = cursor.getInt(columnIndex14);
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public abstract ContentValues c(T t);

    public abstract T d(Cursor cursor) throws SQLException;

    public abstract List<T> e(Cursor cursor) throws SQLException;
}
