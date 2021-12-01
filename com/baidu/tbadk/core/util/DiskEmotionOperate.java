package com.baidu.tbadk.core.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.l;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.nio.ByteBuffer;
/* loaded from: classes9.dex */
public class DiskEmotionOperate extends DiskFileOperate {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Bitmap mBitmap;
    public DiskPicHeader mDiskPicHeader;
    public BitmapFactory.Options mOptions;

    /* loaded from: classes9.dex */
    public static class DiskPicHeader {
        public static /* synthetic */ Interceptable $ic = null;
        public static byte GIF_FLAG = Byte.MIN_VALUE;
        public static final int MAGIC_DIGIT = 1786600510;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mIsGif;
        public long mValidTime;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-679821857, "Lcom/baidu/tbadk/core/util/DiskEmotionOperate$DiskPicHeader;")) == null) {
                return;
            }
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-679821857, "Lcom/baidu/tbadk/core/util/DiskEmotionOperate$DiskPicHeader;");
            }
        }

        public DiskPicHeader() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mIsGif = false;
            this.mValidTime = 0L;
        }

        public static int getHeaderSize() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
                return 13;
            }
            return invokeV.intValue;
        }

        public boolean paserFromByte(byte[] bArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, bArr)) == null) {
                if (bArr == null || bArr.length < getHeaderSize()) {
                    return false;
                }
                ByteBuffer wrap = ByteBuffer.wrap(bArr, 0, getHeaderSize());
                if (wrap.getInt() != 1786600510) {
                    return false;
                }
                if ((wrap.get() & GIF_FLAG) != 0) {
                    this.mIsGif = true;
                }
                this.mValidTime = wrap.getLong();
                return true;
            }
            return invokeL.booleanValue;
        }

        public byte[] toByteArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                ByteBuffer allocate = ByteBuffer.allocate(getHeaderSize());
                allocate.putInt(MAGIC_DIGIT);
                allocate.put(this.mIsGif ? (byte) (GIF_FLAG | 0) : (byte) 0);
                allocate.putLong(this.mValidTime);
                allocate.flip();
                return allocate.array();
            }
            return (byte[]) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskEmotionOperate(String str, String str2, DiskFileOperate.Action action) {
        super(str, str2, action);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, action};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mBitmap = null;
        this.mOptions = null;
        this.mDiskPicHeader = null;
        this.mDiskPicHeader = new DiskPicHeader();
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public byte[] buildFormatData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.mData == null) {
                return null;
            }
            return this.mDiskPicHeader.toByteArray();
        }
        return (byte[]) invokeV.objValue;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public boolean formatData(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bArr)) == null) {
            if (bArr == null) {
                return false;
            }
            if (this.mOptions == null) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                this.mOptions = options;
                options.inPreferredConfig = Bitmap.Config.RGB_565;
            }
            boolean paserFromByte = this.mDiskPicHeader.paserFromByte(bArr);
            long j2 = this.mDiskPicHeader.mValidTime;
            if (j2 == 0 || j2 >= System.currentTimeMillis()) {
                int headerSize = DiskPicHeader.getHeaderSize();
                if (!paserFromByte) {
                    headerSize = 0;
                }
                try {
                    this.mBitmap = BitmapFactory.decodeByteArray(bArr, headerSize, bArr.length - headerSize, this.mOptions);
                } catch (Error e2) {
                    BdLog.e(e2.getMessage());
                }
                return this.mBitmap != null;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Bitmap getBitmap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mBitmap : (Bitmap) invokeV.objValue;
    }

    public BitmapFactory.Options getOptions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mOptions : (BitmapFactory.Options) invokeV.objValue;
    }

    public long getValidTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mDiskPicHeader.mValidTime : invokeV.longValue;
    }

    public boolean isGif() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mDiskPicHeader.mIsGif : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.lib.Disk.ops.DiskFileOperate
    public void setData(byte[] bArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bArr) == null) {
            super.setData(bArr);
            if (isGif() || !l.A(bArr)) {
                return;
            }
            setGif(true);
        }
    }

    public void setGif(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.mDiskPicHeader.mIsGif = z;
        }
    }

    public void setOptions(BitmapFactory.Options options) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, options) == null) {
            this.mOptions = options;
        }
    }

    public void setValidTime(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048585, this, j2) == null) {
            this.mDiskPicHeader.mValidTime = j2;
        }
    }
}
