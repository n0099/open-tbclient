package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import androidx.collection.ArrayMap;
import androidx.core.view.InputDeviceCompat;
import androidx.versionedparcelable.VersionedParcel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Set;
/* loaded from: classes.dex */
public class VersionedParcelStream extends VersionedParcel {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_BOOLEAN = 5;
    public static final int TYPE_BOOLEAN_ARRAY = 6;
    public static final int TYPE_DOUBLE = 7;
    public static final int TYPE_DOUBLE_ARRAY = 8;
    public static final int TYPE_FLOAT = 13;
    public static final int TYPE_FLOAT_ARRAY = 14;
    public static final int TYPE_INT = 9;
    public static final int TYPE_INT_ARRAY = 10;
    public static final int TYPE_LONG = 11;
    public static final int TYPE_LONG_ARRAY = 12;
    public static final int TYPE_NULL = 0;
    public static final int TYPE_STRING = 3;
    public static final int TYPE_STRING_ARRAY = 4;
    public static final int TYPE_SUB_BUNDLE = 1;
    public static final int TYPE_SUB_PERSISTABLE_BUNDLE = 2;
    public static final Charset UTF_16;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCount;
    public DataInputStream mCurrentInput;
    public DataOutputStream mCurrentOutput;
    public FieldBuffer mFieldBuffer;
    public int mFieldId;
    public int mFieldSize;
    public boolean mIgnoreParcelables;
    public final DataInputStream mMasterInput;
    public final DataOutputStream mMasterOutput;

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean isStream() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public CharSequence readCharSequence() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (CharSequence) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T readParcelable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return null;
        }
        return (T) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public IBinder readStrongBinder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return null;
        }
        return (IBinder) invokeV.objValue;
    }

    /* loaded from: classes.dex */
    public static class FieldBuffer {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final DataOutputStream mDataStream;
        public final int mFieldId;
        public final ByteArrayOutputStream mOutput;
        public final DataOutputStream mTarget;

        public FieldBuffer(int i, DataOutputStream dataOutputStream) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i), dataOutputStream};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mOutput = new ByteArrayOutputStream();
            this.mDataStream = new DataOutputStream(this.mOutput);
            this.mFieldId = i;
            this.mTarget = dataOutputStream;
        }

        public void flushField() throws IOException {
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mDataStream.flush();
                int size = this.mOutput.size();
                int i2 = this.mFieldId << 16;
                if (size >= 65535) {
                    i = 65535;
                } else {
                    i = size;
                }
                this.mTarget.writeInt(i2 | i);
                if (size >= 65535) {
                    this.mTarget.writeInt(size);
                }
                this.mOutput.writeTo(this.mTarget);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(209365642, "Landroidx/versionedparcelable/VersionedParcelStream;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(209365642, "Landroidx/versionedparcelable/VersionedParcelStream;");
                return;
            }
        }
        UTF_16 = Charset.forName("UTF-16");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void closeField() {
        FieldBuffer fieldBuffer;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (fieldBuffer = this.mFieldBuffer) != null) {
            try {
                if (fieldBuffer.mOutput.size() != 0) {
                    this.mFieldBuffer.flushField();
                }
                this.mFieldBuffer = null;
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public VersionedParcel createSubParcel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new VersionedParcelStream(this.mCurrentInput, this.mCurrentOutput, this.mReadCache, this.mWriteCache, this.mParcelizerCache);
        }
        return (VersionedParcel) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readBoolean() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            try {
                return this.mCurrentInput.readBoolean();
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
        return invokeV.booleanValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public Bundle readBundle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int readInt = readInt();
            if (readInt < 0) {
                return null;
            }
            Bundle bundle = new Bundle();
            for (int i = 0; i < readInt; i++) {
                readObject(readInt(), readString(), bundle);
            }
            return bundle;
        }
        return (Bundle) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] readByteArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            try {
                int readInt = this.mCurrentInput.readInt();
                if (readInt > 0) {
                    byte[] bArr = new byte[readInt];
                    this.mCurrentInput.readFully(bArr);
                    return bArr;
                }
                return null;
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public double readDouble() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            try {
                return this.mCurrentInput.readDouble();
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
        return invokeV.doubleValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public float readFloat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            try {
                return this.mCurrentInput.readFloat();
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
        return invokeV.floatValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int readInt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            try {
                return this.mCurrentInput.readInt();
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
        return invokeV.intValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public long readLong() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            try {
                return this.mCurrentInput.readLong();
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
        return invokeV.longValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream) {
        this(inputStream, outputStream, new ArrayMap(), new ArrayMap(), new ArrayMap());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, outputStream};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((InputStream) objArr2[0], (OutputStream) objArr2[1], (ArrayMap) objArr2[2], (ArrayMap) objArr2[3], (ArrayMap) objArr2[4]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VersionedParcelStream(InputStream inputStream, OutputStream outputStream, ArrayMap<String, Method> arrayMap, ArrayMap<String, Method> arrayMap2, ArrayMap<String, Class> arrayMap3) {
        super(arrayMap, arrayMap2, arrayMap3);
        DataInputStream dataInputStream;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {inputStream, outputStream, arrayMap, arrayMap2, arrayMap3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((ArrayMap) objArr2[0], (ArrayMap) objArr2[1], (ArrayMap) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mCount = 0;
        this.mFieldId = -1;
        this.mFieldSize = -1;
        if (inputStream != null) {
            dataInputStream = new DataInputStream(new FilterInputStream(this, inputStream) { // from class: androidx.versionedparcelable.VersionedParcelStream.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ VersionedParcelStream this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(inputStream);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext2 = TitanRuntime.newInitContext();
                        newInitContext2.initArgs = r2;
                        Object[] objArr3 = {this, inputStream};
                        interceptable2.invokeUnInit(65536, newInitContext2);
                        int i3 = newInitContext2.flag;
                        if ((i3 & 1) != 0) {
                            int i4 = i3 & 2;
                            super((InputStream) newInitContext2.callArgs[0]);
                            newInitContext2.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext2);
                            return;
                        }
                    }
                    this.this$0 = this;
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read() throws IOException {
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        VersionedParcelStream versionedParcelStream = this.this$0;
                        int i3 = versionedParcelStream.mFieldSize;
                        if (i3 != -1 && versionedParcelStream.mCount >= i3) {
                            throw new IOException();
                        }
                        int read = super.read();
                        this.this$0.mCount++;
                        return read;
                    }
                    return invokeV.intValue;
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public int read(byte[] bArr, int i3, int i4) throws IOException {
                    InterceptResult invokeLII;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeLII = interceptable2.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr, i3, i4)) == null) {
                        VersionedParcelStream versionedParcelStream = this.this$0;
                        int i5 = versionedParcelStream.mFieldSize;
                        if (i5 != -1 && versionedParcelStream.mCount >= i5) {
                            throw new IOException();
                        }
                        int read = super.read(bArr, i3, i4);
                        if (read > 0) {
                            this.this$0.mCount += read;
                        }
                        return read;
                    }
                    return invokeLII.intValue;
                }

                @Override // java.io.FilterInputStream, java.io.InputStream
                public long skip(long j) throws IOException {
                    InterceptResult invokeJ;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeJ = interceptable2.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j)) == null) {
                        VersionedParcelStream versionedParcelStream = this.this$0;
                        int i3 = versionedParcelStream.mFieldSize;
                        if (i3 != -1 && versionedParcelStream.mCount >= i3) {
                            throw new IOException();
                        }
                        long skip = super.skip(j);
                        if (skip > 0) {
                            this.this$0.mCount += (int) skip;
                        }
                        return skip;
                    }
                    return invokeJ.longValue;
                }
            });
        } else {
            dataInputStream = null;
        }
        this.mMasterInput = dataInputStream;
        DataOutputStream dataOutputStream = outputStream != null ? new DataOutputStream(outputStream) : null;
        this.mMasterOutput = dataOutputStream;
        this.mCurrentInput = this.mMasterInput;
        this.mCurrentOutput = dataOutputStream;
    }

    private void readObject(int i, String str, Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65539, this, i, str, bundle) == null) {
            switch (i) {
                case 0:
                    bundle.putParcelable(str, null);
                    return;
                case 1:
                    bundle.putBundle(str, readBundle());
                    return;
                case 2:
                    bundle.putBundle(str, readBundle());
                    return;
                case 3:
                    bundle.putString(str, readString());
                    return;
                case 4:
                    bundle.putStringArray(str, (String[]) readArray(new String[0]));
                    return;
                case 5:
                    bundle.putBoolean(str, readBoolean());
                    return;
                case 6:
                    bundle.putBooleanArray(str, readBooleanArray());
                    return;
                case 7:
                    bundle.putDouble(str, readDouble());
                    return;
                case 8:
                    bundle.putDoubleArray(str, readDoubleArray());
                    return;
                case 9:
                    bundle.putInt(str, readInt());
                    return;
                case 10:
                    bundle.putIntArray(str, readIntArray());
                    return;
                case 11:
                    bundle.putLong(str, readLong());
                    return;
                case 12:
                    bundle.putLongArray(str, readLongArray());
                    return;
                case 13:
                    bundle.putFloat(str, readFloat());
                    return;
                case 14:
                    bundle.putFloatArray(str, readFloatArray());
                    return;
                default:
                    throw new RuntimeException("Unknown type " + i);
            }
        }
    }

    private void writeObject(Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, obj) == null) {
            if (obj == null) {
                writeInt(0);
            } else if (obj instanceof Bundle) {
                writeInt(1);
                writeBundle((Bundle) obj);
            } else if (obj instanceof String) {
                writeInt(3);
                writeString((String) obj);
            } else if (obj instanceof String[]) {
                writeInt(4);
                writeArray((String[]) obj);
            } else if (obj instanceof Boolean) {
                writeInt(5);
                writeBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof boolean[]) {
                writeInt(6);
                writeBooleanArray((boolean[]) obj);
            } else if (obj instanceof Double) {
                writeInt(7);
                writeDouble(((Double) obj).doubleValue());
            } else if (obj instanceof double[]) {
                writeInt(8);
                writeDoubleArray((double[]) obj);
            } else if (obj instanceof Integer) {
                writeInt(9);
                writeInt(((Integer) obj).intValue());
            } else if (obj instanceof int[]) {
                writeInt(10);
                writeIntArray((int[]) obj);
            } else if (obj instanceof Long) {
                writeInt(11);
                writeLong(((Long) obj).longValue());
            } else if (obj instanceof long[]) {
                writeInt(12);
                writeLongArray((long[]) obj);
            } else if (obj instanceof Float) {
                writeInt(13);
                writeFloat(((Float) obj).floatValue());
            } else if (obj instanceof float[]) {
                writeInt(14);
                writeFloatArray((float[]) obj);
            } else {
                throw new IllegalArgumentException("Unsupported type " + obj.getClass());
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean readField(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            while (this.mFieldId != i) {
                try {
                    if (String.valueOf(this.mFieldId).compareTo(String.valueOf(i)) > 0) {
                        return false;
                    }
                    if (this.mCount < this.mFieldSize) {
                        this.mMasterInput.skip(this.mFieldSize - this.mCount);
                    }
                    this.mFieldSize = -1;
                    int readInt = this.mMasterInput.readInt();
                    this.mCount = 0;
                    int i2 = readInt & 65535;
                    if (i2 == 65535) {
                        i2 = this.mMasterInput.readInt();
                    }
                    this.mFieldId = (readInt >> 16) & 65535;
                    this.mFieldSize = i2;
                } catch (IOException unused) {
                    return false;
                }
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBundle(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, bundle) == null) {
            try {
                if (bundle != null) {
                    Set<String> keySet = bundle.keySet();
                    this.mCurrentOutput.writeInt(keySet.size());
                    for (String str : keySet) {
                        writeString(str);
                        writeObject(bundle.get(str));
                    }
                    return;
                }
                this.mCurrentOutput.writeInt(-1);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String readString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            try {
                int readInt = this.mCurrentInput.readInt();
                if (readInt > 0) {
                    byte[] bArr = new byte[readInt];
                    this.mCurrentInput.readFully(bArr);
                    return new String(bArr, UTF_16);
                }
                return null;
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
        return (String) invokeV.objValue;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setOutputField(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            closeField();
            FieldBuffer fieldBuffer = new FieldBuffer(i, this.mMasterOutput);
            this.mFieldBuffer = fieldBuffer;
            this.mCurrentOutput = fieldBuffer.mDataStream;
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeBoolean(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            try {
                this.mCurrentOutput.writeBoolean(z);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bArr) == null) {
            try {
                if (bArr != null) {
                    this.mCurrentOutput.writeInt(bArr.length);
                    this.mCurrentOutput.write(bArr);
                    return;
                }
                this.mCurrentOutput.writeInt(-1);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeCharSequence(CharSequence charSequence) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048597, this, charSequence) != null) || this.mIgnoreParcelables) {
            return;
        }
        throw new RuntimeException("CharSequence cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeDouble(double d) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Double.valueOf(d)}) == null) {
            try {
                this.mCurrentOutput.writeDouble(d);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeFloat(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f) == null) {
            try {
                this.mCurrentOutput.writeFloat(f);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeInt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i) == null) {
            try {
                this.mCurrentOutput.writeInt(i);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeLong(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            try {
                this.mCurrentOutput.writeLong(j);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeParcelable(Parcelable parcelable) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048602, this, parcelable) != null) || this.mIgnoreParcelables) {
            return;
        }
        throw new RuntimeException("Parcelables cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeString(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            try {
                if (str != null) {
                    byte[] bytes = str.getBytes(UTF_16);
                    this.mCurrentOutput.writeInt(bytes.length);
                    this.mCurrentOutput.write(bytes);
                    return;
                }
                this.mCurrentOutput.writeInt(-1);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongBinder(IBinder iBinder) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048604, this, iBinder) != null) || this.mIgnoreParcelables) {
            return;
        }
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeStrongInterface(IInterface iInterface) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048605, this, iInterface) != null) || this.mIgnoreParcelables) {
            return;
        }
        throw new RuntimeException("Binders cannot be written to an OutputStream");
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void setSerializationFlags(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            if (z) {
                this.mIgnoreParcelables = z2;
                return;
            }
            throw new RuntimeException("Serialization of this object is not allowed");
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void writeByteArray(byte[] bArr, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048596, this, bArr, i, i2) == null) {
            try {
                if (bArr != null) {
                    this.mCurrentOutput.writeInt(i2);
                    this.mCurrentOutput.write(bArr, i, i2);
                    return;
                }
                this.mCurrentOutput.writeInt(-1);
            } catch (IOException e) {
                throw new VersionedParcel.ParcelException(e);
            }
        }
    }
}
