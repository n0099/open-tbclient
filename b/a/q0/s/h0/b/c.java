package b.a.q0.s.h0.b;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.e.f.l.e;
import b.a.e.f.q.h;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTaskParallel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.httpNet.WebClient;
import com.baidu.tbadk.core.util.resourceLoaderProc.DiskCancelWorker;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class c implements e<a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public c() {
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

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.f.l.e
    /* renamed from: a */
    public a getFromLocal(String str, String str2, int i2, int i3, b.a.e.f.l.b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.INFO);
            diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            diskFileOperate.setSubFolder(false);
            diskFileOperate.setIsFormatData(false);
            if (bVar != null) {
                DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                diskCancelWorker.setOperate(diskFileOperate);
                bVar.f1862a = diskCancelWorker;
            }
            diskFileOperate.call();
            if (diskFileOperate.isSuccess()) {
                String desPath = diskFileOperate.getDesPath();
                a aVar = new a();
                aVar.f13876a = str;
                aVar.f13877b = desPath;
                return aVar;
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.f.l.e
    /* renamed from: b */
    public a getFromMemory(String str, String str2, int i2, int i3, boolean z, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), objArr})) == null) {
            return null;
        }
        return (a) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.f.l.e
    /* renamed from: c */
    public a getFromRemote(String str, String str2, int i2, int i3, b.a.e.f.l.b bVar, Object... objArr) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{str, str2, Integer.valueOf(i2), Integer.valueOf(i3), bVar, objArr})) == null) {
            int i4 = 1;
            String str3 = null;
            String valueOf = objArr.length == 1 ? String.valueOf(objArr[0]) : null;
            a aVar = new a();
            WebClient webClient = new WebClient();
            if (bVar != null) {
                bVar.f1862a = webClient;
            }
            String str4 = TbConfig.SERVER_ADDRESS + TbConfig.VOICE_DATA + "?voice_md5=" + str;
            if (!TextUtils.isEmpty(valueOf)) {
                str4 = str4 + "&play_from=" + valueOf;
            }
            byte[] downloadCommonBytes = webClient.downloadCommonBytes(str4);
            if (!webClient.IsRequestSuccess()) {
                aVar.f13878c = 3;
                aVar.f13879d = h.a(R.string.neterror);
                return aVar;
            } else if (downloadCommonBytes == null || downloadCommonBytes.length == 0) {
                aVar.f13878c = 4;
                aVar.f13879d = h.a(R.string.voice_cache_error_no_file);
                return aVar;
            } else {
                if (str == null) {
                    i4 = 5;
                } else if (downloadCommonBytes == null || downloadCommonBytes.length == 0) {
                    i4 = 6;
                } else {
                    DiskFileOperate diskFileOperate = new DiskFileOperate("voice", str, DiskFileOperate.Action.WRITE);
                    diskFileOperate.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
                    diskFileOperate.setSubFolder(false);
                    diskFileOperate.setData(downloadCommonBytes);
                    if (bVar != null) {
                        DiskCancelWorker diskCancelWorker = new DiskCancelWorker();
                        diskCancelWorker.setOperate(diskFileOperate);
                        bVar.f1862a = diskCancelWorker;
                    }
                    diskFileOperate.call();
                    if (diskFileOperate.isSuccess() && diskFileOperate.getFileInfo() != null) {
                        str3 = diskFileOperate.getFileInfo().getAbsolutePath();
                        i4 = 0;
                    } else if (FileHelper.getAvailableSize() < downloadCommonBytes.length) {
                        i4 = 2;
                    }
                }
                if (i4 == 0) {
                    aVar.f13877b = str3;
                    aVar.f13876a = str;
                } else {
                    aVar.f13878c = i4;
                    aVar.f13879d = a.a(i4);
                }
                return aVar;
            }
        }
        return (a) invokeCommon.objValue;
    }

    @Override // b.a.e.f.l.e
    public BdAsyncTaskParallel getAsyncTaskParallel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (BdAsyncTaskParallel) invokeV.objValue;
    }

    @Override // b.a.e.f.l.e
    public int getAsyncTaskPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return 2;
        }
        return invokeV.intValue;
    }

    @Override // b.a.e.f.l.e
    public boolean isNeedLoad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // b.a.e.f.l.e
    public void updateMemory(String str, Object obj, int i2, int i3, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{str, obj, Integer.valueOf(i2), Integer.valueOf(i3), objArr}) == null) {
        }
    }
}
