package androidx.room;

import androidx.annotation.RestrictTo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class RoomMasterTable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_IDENTITY_HASH = "identity_hash";
    public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)";
    public static final String DEFAULT_ID = "42";
    public static final String NAME = "room_master_table";
    public static final String READ_QUERY = "SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1";
    public static final String TABLE_NAME = "room_master_table";
    public transient /* synthetic */ FieldHolder $fh;

    public RoomMasterTable() {
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

    public static String createInsertQuery(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, \"" + str + "\")";
        }
        return (String) invokeL.objValue;
    }
}
