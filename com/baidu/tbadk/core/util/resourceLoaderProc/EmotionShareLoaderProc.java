package com.baidu.tbadk.core.util.resourceLoaderProc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.dg;
import com.repackage.gg;
import com.repackage.ob;
import com.repackage.rb;
import com.repackage.um;
import java.io.File;
/* loaded from: classes3.dex */
public class EmotionShareLoaderProc implements gg<EmotionShare> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MemeLoaderProc2 impl;

    /* loaded from: classes3.dex */
    public static class EmotionShare {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public um image;
        public String path;

        public EmotionShare(um umVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {umVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.image = umVar;
            this.path = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class ForceDeleteFileOperate extends DiskFileOperate implements ob {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ForceDeleteFileOperate(String str, String str2, DiskFileOperate.Action action) {
            super(str, str2, action);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, action};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((String) objArr2[0], (String) objArr2[1], (DiskFileOperate.Action) objArr2[2]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // com.repackage.ob
        public boolean compare(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    public EmotionShareLoaderProc() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        MemeLoaderProc2 memeLoaderProc2 = new MemeLoaderProc2();
        this.impl = memeLoaderProc2;
        memeLoaderProc2.setIsShare(true);
    }

    private DiskFileOperate buildExtractToShareHubDiskOp(um umVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, umVar, str)) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(TbConfig.SHARE_HUB_DIR_NAME, TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE_FORCE);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            diskFileOperate.setSubFolder(true);
            diskFileOperate.setSavedCache(true);
            diskFileOperate.setSdCard(true);
            diskFileOperate.setData(umVar.k());
            return diskFileOperate;
        }
        return (DiskFileOperate) invokeLL.objValue;
    }

    private void clearShareHub() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ForceDeleteFileOperate forceDeleteFileOperate = new ForceDeleteFileOperate(TbConfig.SHARE_HUB_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
            forceDeleteFileOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            forceDeleteFileOperate.setSubFolder(true);
            forceDeleteFileOperate.setSavedCache(true);
            forceDeleteFileOperate.setSdCard(true);
            rb.f().call(forceDeleteFileOperate);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public EmotionShare m44decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (EmotionShare) invokeLL.objValue;
    }

    @Override // com.repackage.gg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.impl.getAsyncTaskParallel() : (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.repackage.gg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.impl.getAsyncTaskPriority() : invokeV.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public EmotionShare getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (EmotionShare) invokeCommon.objValue;
    }

    @Override // com.repackage.gg
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public void storeLocal(String str, byte[] bArr, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048587, this, str, bArr, objArr) == null) {
        }
    }

    @Override // com.repackage.gg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) {
            this.impl.updateMemory(str, obj, i, i2, objArr);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public EmotionShare getFromLocal(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            clearShareHub();
            um fromLocal = this.impl.getFromLocal(str, str2, i, i2, dgVar, objArr);
            if (fromLocal == null || fromLocal.k() == null) {
                return null;
            }
            DiskFileOperate buildExtractToShareHubDiskOp = buildExtractToShareHubDiskOp(fromLocal, str2);
            if (!rb.f().call(buildExtractToShareHubDiskOp) || buildExtractToShareHubDiskOp.getFileInfo() == null) {
                return null;
            }
            return new EmotionShare(fromLocal, buildExtractToShareHubDiskOp.getFileInfo().getAbsolutePath());
        }
        return (EmotionShare) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.repackage.gg
    public EmotionShare getFromRemote(String str, String str2, int i, int i2, dg dgVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), dgVar, objArr})) == null) {
            clearShareHub();
            um fromRemote = this.impl.getFromRemote(str, str2, i, i2, dgVar, objArr);
            if (fromRemote == null || fromRemote.k() == null) {
                return null;
            }
            DiskFileOperate buildExtractToShareHubDiskOp = buildExtractToShareHubDiskOp(fromRemote, str2);
            if (!rb.f().call(buildExtractToShareHubDiskOp) || buildExtractToShareHubDiskOp.getFileInfo() == null) {
                return null;
            }
            return new EmotionShare(fromRemote, buildExtractToShareHubDiskOp.getFileInfo().getAbsolutePath());
        }
        return (EmotionShare) invokeCommon.objValue;
    }
}
