package com.baidu.tbadk.core.util.resourceLoaderProc;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tieba.ag;
import com.baidu.tieba.dg;
import com.baidu.tieba.rb;
import com.baidu.tieba.sm;
import com.baidu.tieba.ub;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes3.dex */
public class EmotionShareLoaderProc implements dg<EmotionShare> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final MemeLoaderProc2 impl;

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: decodeToResource */
    public EmotionShare m49decodeToResource(byte[] bArr, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, bArr, objArr)) == null) {
            return null;
        }
        return (EmotionShare) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.dg
    public EmotionShare getFromMemory(String str, String str2, int i, int i2, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (EmotionShare) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.dg
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

    /* loaded from: classes3.dex */
    public static class EmotionShare {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public sm image;
        public String path;

        public EmotionShare(sm smVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {smVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.image = smVar;
            this.path = str;
        }
    }

    /* loaded from: classes3.dex */
    public static class ForceDeleteFileOperate extends DiskFileOperate implements rb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        @Override // com.baidu.tieba.rb
        public boolean compare(File file) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, file)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }

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

    private void clearShareHub() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            ForceDeleteFileOperate forceDeleteFileOperate = new ForceDeleteFileOperate(TbConfig.SHARE_HUB_DIR_NAME, null, DiskFileOperate.Action.DELETE_FILES);
            forceDeleteFileOperate.setOperateType(DiskFileOperate.OperateType.TRY_SUCCESS);
            forceDeleteFileOperate.setSubFolder(true);
            forceDeleteFileOperate.setSavedCache(true);
            forceDeleteFileOperate.setSdCard(true);
            ub.f().call(forceDeleteFileOperate);
        }
    }

    @Override // com.baidu.tieba.dg
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.impl.getAsyncTaskParallel();
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // com.baidu.tieba.dg
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.impl.getAsyncTaskPriority();
        }
        return invokeV.intValue;
    }

    private DiskFileOperate buildExtractToShareHubDiskOp(sm smVar, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, smVar, str)) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate(TbConfig.SHARE_HUB_DIR_NAME, TbMd5.getNameMd5FromUrl(str), DiskFileOperate.Action.WRITE_FORCE);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            diskFileOperate.setSubFolder(true);
            diskFileOperate.setSavedCache(true);
            diskFileOperate.setSdCard(true);
            diskFileOperate.setData(smVar.k());
            return diskFileOperate;
        }
        return (DiskFileOperate) invokeLL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.dg
    public EmotionShare getFromLocal(String str, String str2, int i, int i2, ag agVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048580, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), agVar, objArr})) == null) {
            clearShareHub();
            sm fromLocal = this.impl.getFromLocal(str, str2, i, i2, agVar, objArr);
            if (fromLocal != null && fromLocal.k() != null) {
                DiskFileOperate buildExtractToShareHubDiskOp = buildExtractToShareHubDiskOp(fromLocal, str2);
                if (ub.f().call(buildExtractToShareHubDiskOp) && buildExtractToShareHubDiskOp.getFileInfo() != null) {
                    return new EmotionShare(fromLocal, buildExtractToShareHubDiskOp.getFileInfo().getAbsolutePath());
                }
                return null;
            }
            return null;
        }
        return (EmotionShare) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.dg
    public EmotionShare getFromRemote(String str, String str2, int i, int i2, ag agVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2), agVar, objArr})) == null) {
            clearShareHub();
            sm fromRemote = this.impl.getFromRemote(str, str2, i, i2, agVar, objArr);
            if (fromRemote != null && fromRemote.k() != null) {
                DiskFileOperate buildExtractToShareHubDiskOp = buildExtractToShareHubDiskOp(fromRemote, str2);
                if (ub.f().call(buildExtractToShareHubDiskOp) && buildExtractToShareHubDiskOp.getFileInfo() != null) {
                    return new EmotionShare(fromRemote, buildExtractToShareHubDiskOp.getFileInfo().getAbsolutePath());
                }
                return null;
            }
            return null;
        }
        return (EmotionShare) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.dg
    public void updateMemory(String str, Object obj, int i, int i2, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{str, obj, Integer.valueOf(i), Integer.valueOf(i2), objArr}) == null) {
            this.impl.updateMemory(str, obj, i, i2, objArr);
        }
    }
}
