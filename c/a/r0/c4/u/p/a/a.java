package c.a.r0.c4.u.p.a;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.data.VideoCategoryClassData;
import com.baidu.tieba.write.write.work.classdialog.model.GetSelectClassReqMessage;
import com.baidu.tieba.write.write.work.selecttag.model.GetSelectTagReqMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f17032a;

    /* renamed from: b  reason: collision with root package name */
    public List<List<String>> f17033b;

    /* renamed from: c  reason: collision with root package name */
    public VideoCategoryClassData f17034c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f17035d;

    public a(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f17032a = new ArrayList();
        this.f17033b = new ArrayList();
        this.f17034c = new VideoCategoryClassData();
        this.f17035d = bdUniqueId;
    }

    public VideoCategoryClassData a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i2, i3)) == null) {
            this.f17034c.setFirstClass(this.f17032a.get(i2));
            this.f17034c.setSecondClass(this.f17033b.get(i2).get(i3));
            this.f17034c.getTags().clear();
            return this.f17034c;
        }
        return (VideoCategoryClassData) invokeII.objValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17032a : (List) invokeV.objValue;
    }

    public List<List<String>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17033b : (List) invokeV.objValue;
    }

    public ArrayList<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f17034c.getTags() : (ArrayList) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            GetSelectClassReqMessage getSelectClassReqMessage = new GetSelectClassReqMessage();
            getSelectClassReqMessage.setTag(this.f17035d);
            MessageManager.getInstance().sendMessage(getSelectClassReqMessage);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            GetSelectTagReqMessage getSelectTagReqMessage = new GetSelectTagReqMessage();
            getSelectTagReqMessage.setTag(this.f17035d);
            getSelectTagReqMessage.setFirstClass(this.f17034c.getFirstClass());
            getSelectTagReqMessage.setSecondClass(this.f17034c.getSecondClass());
            MessageManager.getInstance().sendMessage(getSelectTagReqMessage);
        }
    }

    public void g(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.f17032a.clear();
            this.f17032a.addAll(list);
        }
    }

    public void h(List<List<String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f17033b.clear();
            this.f17033b.addAll(list);
        }
    }

    public void i(VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoCategoryClassData) == null) {
            this.f17034c = videoCategoryClassData;
        }
    }
}
