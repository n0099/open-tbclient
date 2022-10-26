package androidx.room;

import androidx.sqlite.db.SupportSQLiteStatement;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public abstract class SharedSQLiteStatement {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RoomDatabase mDatabase;
    public final AtomicBoolean mLock;
    public volatile SupportSQLiteStatement mStmt;

    public abstract String createQuery();

    public SharedSQLiteStatement(RoomDatabase roomDatabase) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {roomDatabase};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mLock = new AtomicBoolean(false);
        this.mDatabase = roomDatabase;
    }

    private SupportSQLiteStatement createNewStatement() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            return this.mDatabase.compileStatement(createQuery());
        }
        return (SupportSQLiteStatement) invokeV.objValue;
    }

    public SupportSQLiteStatement acquire() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            assertNotMainThread();
            return getStmt(this.mLock.compareAndSet(false, true));
        }
        return (SupportSQLiteStatement) invokeV.objValue;
    }

    public void assertNotMainThread() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mDatabase.assertNotMainThread();
        }
    }

    private SupportSQLiteStatement getStmt(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, this, z)) == null) {
            if (z) {
                if (this.mStmt == null) {
                    this.mStmt = createNewStatement();
                }
                return this.mStmt;
            }
            return createNewStatement();
        }
        return (SupportSQLiteStatement) invokeZ.objValue;
    }

    public void release(SupportSQLiteStatement supportSQLiteStatement) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, supportSQLiteStatement) == null) && supportSQLiteStatement == this.mStmt) {
            this.mLock.set(false);
        }
    }
}
