package c.a.e0.g.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.spswitch.emotion.resource.EmotionResourceInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.tachikoma.core.component.TKBase;
import com.tencent.open.SocialOperation;
/* loaded from: classes.dex */
public class c extends SQLiteOpenHelper {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, "nps.db", (SQLiteDatabase.CursorFactory) null, 3);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], (SQLiteDatabase.CursorFactory) objArr2[2], ((Integer) objArr2[3]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            try {
                sQLiteDatabase.execSQL("ALTER TABLE bundleinfo ADD silence INTEGER DEFAULT 1");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public final void b(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE ");
            sb.append("bundleinfo");
            sb.append(" ADD COLUMN ");
            sb.append("silence_update");
            sb.append(" INTEGER DEFAULT ");
            sb.append(1);
            sb.append(";");
            try {
                sQLiteDatabase.execSQL(sb.toString());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            sb.delete(0, sb.length());
            sb.append("ALTER TABLE ");
            sb.append("bundleinfo");
            sb.append(" ADD COLUMN ");
            sb.append("wifionly");
            sb.append(" INTEGER DEFAULT ");
            sb.append(1);
            sb.append(";");
            try {
                sQLiteDatabase.execSQL(sb.toString());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    public final void c(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            sQLiteDatabase.execSQL(e());
        }
    }

    public final String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return "CREATE TABLE bundleinfo (_id INTEGER PRIMARY KEY," + EmotionResourceInfo.JSON_KEY_PKG_NAME + " TEXT NOT NULL,version_code INTEGER,path TEXT,min_version INTEGER,update_v LONG,type INTEGER DEFAULT 0,broken INTEGER DEFAULT 0,force_update INTEGER DEFAULT 0,forbidden INTEGER DEFAULT 0," + PackageTable.MD5 + " TEXT," + SocialOperation.GAME_SIGNATURE + " TEXT,name TEXT,description TEXT,download_url TEXT,icon_url TEXT,dependence TEXT," + TKBase.VISIBILITY_VISIBLE + " INTEGER DEFAULT 0,removalbe INTEGER DEFAULT 0,size TEXT,need_remove INTEGER DEFAULT 0," + PackageTable.ABI + " INTEGER DEFAULT -1,ext TEXT,silence INTEGER DEFAULT 1,silence_update INTEGER DEFAULT 1,wifionly INTEGER DEFAULT 1 );";
        }
        return (String) invokeV.objValue;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, sQLiteDatabase) == null) {
            c(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048581, this, sQLiteDatabase, i2, i3) == null) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS bundleinfo");
            onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048582, this, sQLiteDatabase, i2, i3) == null) {
            if (i2 == 1) {
                a(sQLiteDatabase);
                b(sQLiteDatabase);
            } else if (i2 != 2) {
            } else {
                b(sQLiteDatabase);
            }
        }
    }
}
