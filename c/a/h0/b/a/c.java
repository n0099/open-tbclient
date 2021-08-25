package c.a.h0.b.a;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class c implements Cursor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Bundle f3475e;

    public c(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bundle};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f3475e = bundle;
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
        }
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int i2, CharArrayBuffer charArrayBuffer) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, charArrayBuffer) == null) {
        }
    }

    @Override // android.database.Cursor
    public void deactivate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
        }
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) ? new byte[0] : (byte[]) invokeI.objValue;
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            return 0;
        }
        return invokeL.intValue;
    }

    @Override // android.database.Cursor
    public String getColumnName(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // android.database.Cursor
    public String[] getColumnNames() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new String[0] : (String[]) invokeV.objValue;
    }

    @Override // android.database.Cursor
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.database.Cursor
    public double getDouble(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048586, this, i2)) == null) {
            return 0.0d;
        }
        return invokeI.doubleValue;
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f3475e : (Bundle) invokeV.objValue;
    }

    @Override // android.database.Cursor
    public float getFloat(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            return 0.0f;
        }
        return invokeI.floatValue;
    }

    @Override // android.database.Cursor
    public int getInt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) {
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.database.Cursor
    public long getLong(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return null;
        }
        return (Uri) invokeV.objValue;
    }

    @Override // android.database.Cursor
    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.database.Cursor
    public short getShort(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048593, this, i2)) == null) {
            return (short) 0;
        }
        return invokeI.shortValue;
    }

    @Override // android.database.Cursor
    public String getString(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048594, this, i2)) == null) {
            return null;
        }
        return (String) invokeI.objValue;
    }

    @Override // android.database.Cursor
    public int getType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            return 0;
        }
        return invokeI.intValue;
    }

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isAfterLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isBeforeFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean isNull(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean move(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean moveToFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean moveToLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean moveToNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean moveToPosition(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048607, this, i2)) == null) {
            return false;
        }
        return invokeI.booleanValue;
    }

    @Override // android.database.Cursor
    public boolean moveToPrevious() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver contentObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, contentObserver) == null) {
        }
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, dataSetObserver) == null) {
        }
    }

    @Override // android.database.Cursor
    public boolean requery() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle bundle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, bundle)) == null) {
            return null;
        }
        return (Bundle) invokeL.objValue;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, bundle) == null) {
            this.f3475e = bundle;
        }
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048614, this, contentResolver, uri) == null) {
        }
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver contentObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, contentObserver) == null) {
        }
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048616, this, dataSetObserver) == null) {
        }
    }
}
