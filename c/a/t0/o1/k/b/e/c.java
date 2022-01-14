package c.a.t0.o1.k.b.e;

import android.content.Context;
import android.widget.EditText;
import c.a.s0.x.m;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetaiInputContainer;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class c extends m {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EditText r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context) {
        super(context, (String) null, 29);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (String) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = false;
        this.l = 3;
        TopicDetaiInputContainer topicDetaiInputContainer = new TopicDetaiInputContainer(context);
        this.k = topicDetaiInputContainer;
        this.r = topicDetaiInputContainer.getInputView();
        ((TopicDetaiInputContainer) this.k).setHint(context.getString(R.string.say_your_point));
        this.n = new int[]{4, 13, 24, 3, 9, 6, 12};
    }

    public EditText f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.r : (EditText) invokeV.objValue;
    }
}
