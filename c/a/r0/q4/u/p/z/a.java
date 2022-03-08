package c.a.r0.q4.u.p.z;

import android.widget.TextView;
import com.baidu.tbadk.core.view.AutoChangeLineView;
import com.baidu.tieba.write.write.work.selectview.SelectTagView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* compiled from: lambda */
/* loaded from: classes2.dex */
public final /* synthetic */ class a implements AutoChangeLineView.b {
    public static /* synthetic */ Interceptable $ic;
    public static final /* synthetic */ a a = new a();
    public transient /* synthetic */ FieldHolder $fh;

    private /* synthetic */ a() {
    }

    @Override // com.baidu.tbadk.core.view.AutoChangeLineView.b
    public final CharSequence a(TextView textView, int i2, Object obj) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i2, obj)) == null) ? SelectTagView.b(textView, i2, (String) obj) : (CharSequence) invokeLIL.objValue;
    }
}
