package c.a.p0.q.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.util.List;
/* loaded from: classes2.dex */
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

    public ContentValues a(c.a.p0.q.h.f fVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, fVar)) == null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("bundle_id", fVar.f10961g);
            contentValues.put("category", Integer.valueOf(fVar.f10962h));
            contentValues.put("version_name", fVar.f10964j);
            contentValues.put("version_code", Long.valueOf(fVar.f10963i));
            contentValues.put("size", Long.valueOf(fVar.k));
            contentValues.put(PackageTable.MD5, fVar.l);
            contentValues.put("sign", fVar.m);
            contentValues.put(TTDownloadField.TT_DOWNLOAD_URL, fVar.n);
            contentValues.put(PackageTable.FILE_PATH, fVar.a);
            contentValues.put(PackageTable.CURRENT_SIZE, Long.valueOf(fVar.f10956b));
            contentValues.put("create_time", Long.valueOf(fVar.f10957c));
            contentValues.put("update_time", Long.valueOf(fVar.f10958d));
            contentValues.put("state", Integer.valueOf(fVar.f10959e));
            return contentValues;
        }
        return (ContentValues) invokeL.objValue;
    }

    public boolean b(Cursor cursor, c.a.p0.q.h.f fVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cursor, fVar)) == null) {
            if (cursor != null) {
                int columnIndex = cursor.getColumnIndex("bundle_id");
                int columnIndex2 = cursor.getColumnIndex("category");
                int columnIndex3 = cursor.getColumnIndex("version_name");
                int columnIndex4 = cursor.getColumnIndex("version_code");
                int columnIndex5 = cursor.getColumnIndex("size");
                int columnIndex6 = cursor.getColumnIndex(PackageTable.MD5);
                int columnIndex7 = cursor.getColumnIndex("sign");
                int columnIndex8 = cursor.getColumnIndex(TTDownloadField.TT_DOWNLOAD_URL);
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
                fVar.f10961g = string;
                fVar.f10962h = cursor.getInt(columnIndex2);
                fVar.f10964j = cursor.getString(columnIndex3);
                fVar.f10963i = cursor.getLong(columnIndex4);
                fVar.k = cursor.getLong(columnIndex5);
                fVar.l = cursor.getString(columnIndex6);
                fVar.m = cursor.getString(columnIndex7);
                fVar.n = cursor.getString(columnIndex8);
                fVar.a = cursor.getString(columnIndex10);
                fVar.f10956b = cursor.getLong(columnIndex11);
                fVar.f10957c = cursor.getLong(columnIndex12);
                fVar.f10958d = cursor.getLong(columnIndex13);
                fVar.f10960f = cursor.getLong(columnIndex9);
                fVar.f10959e = cursor.getInt(columnIndex14);
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
