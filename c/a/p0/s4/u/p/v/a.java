package c.a.p0.s4.u.p.v;

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
/* loaded from: classes2.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<String> a;

    /* renamed from: b  reason: collision with root package name */
    public List<List<String>> f18548b;

    /* renamed from: c  reason: collision with root package name */
    public VideoCategoryClassData f18549c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f18550d;

    public a(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        this.f18548b = new ArrayList();
        this.f18549c = new VideoCategoryClassData();
        this.f18550d = bdUniqueId;
    }

    public VideoCategoryClassData a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            this.f18549c.setFirstClass(this.a.get(i));
            this.f18549c.setSecondClass(this.f18548b.get(i).get(i2));
            this.f18549c.getTags().clear();
            return this.f18549c;
        }
        return (VideoCategoryClassData) invokeII.objValue;
    }

    public List<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public List<List<String>> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f18548b : (List) invokeV.objValue;
    }

    public ArrayList<String> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f18549c.getTags() : (ArrayList) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            GetSelectClassReqMessage getSelectClassReqMessage = new GetSelectClassReqMessage();
            getSelectClassReqMessage.setTag(this.f18550d);
            MessageManager.getInstance().sendMessage(getSelectClassReqMessage);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            GetSelectTagReqMessage getSelectTagReqMessage = new GetSelectTagReqMessage();
            getSelectTagReqMessage.setTag(this.f18550d);
            getSelectTagReqMessage.setFirstClass(this.f18549c.getFirstClass());
            getSelectTagReqMessage.setSecondClass(this.f18549c.getSecondClass());
            MessageManager.getInstance().sendMessage(getSelectTagReqMessage);
        }
    }

    public void g(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            this.a.clear();
            this.a.addAll(list);
        }
    }

    public void h(List<List<String>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.f18548b.clear();
            this.f18548b.addAll(list);
        }
    }

    public void i(VideoCategoryClassData videoCategoryClassData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoCategoryClassData) == null) {
            this.f18549c = videoCategoryClassData;
        }
    }
}
