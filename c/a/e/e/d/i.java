package c.a.e.e.d;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.adp.base.BdDatabaseNewCreatedMessage;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class i extends c.a.e.a.k.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(Context context, String str) {
        super(context, str, 1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void a(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, sQLiteDatabase) == null) {
            executeDDLSqlIgnoreAnyErrors(sQLiteDatabase, "CREATE TABLE IF NOT EXISTS cache_meta_info(nameSpace VARCHAR(128) PRIMARY KEY, tableName varchar(64), maxSize int(11) default 0, cacheType varchar(32) not null, cacheVersion int(11) default 0, lastActiveTime bigint(21) default 0)");
        }
    }

    @Override // c.a.e.a.k.c
    public void clearAllTables(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sQLiteDatabase) == null) {
        }
    }

    @Override // c.a.e.a.k.c
    public void createAllTables(SQLiteDatabase sQLiteDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sQLiteDatabase) == null) {
            a(sQLiteDatabase);
            MessageManager.getInstance().dispatchResponsedMessageToUI(new BdDatabaseNewCreatedMessage(sQLiteDatabase));
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, c.a.e.a.k.a
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048579, this, sQLiteDatabase, i2, i3) == null) || i2 >= 1) {
            return;
        }
        a(sQLiteDatabase);
    }
}
