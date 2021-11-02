package b.a.q0.j0.p;

import b.a.q0.j0.b;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.mutiprocess.fps.ImageFpsEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class a implements b<ImageFpsEvent> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public a() {
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
    @Override // b.a.q0.j0.b
    /* renamed from: a */
    public boolean onEvent(ImageFpsEvent imageFpsEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imageFpsEvent)) == null) {
            if (TbadkCoreApplication.getInst().isMainProcess(true)) {
                BdTracesManager.INSTANCE.getFpsTracer().endFpsCollect(ImageViewerConfig.KEY_FPS_IMAGE);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
