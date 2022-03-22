package c.a.p0.s4.u;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tieba.R;
import com.baidu.tieba.write.write.AtListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public AtListActivity f18468b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<MetaData> f18469c;

    /* renamed from: d  reason: collision with root package name */
    public TbCheckBox.b f18470d;

    /* renamed from: e  reason: collision with root package name */
    public c f18471e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f18472f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f18473g;

    /* renamed from: c.a.p0.s4.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1397a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f18474b;

        public View$OnClickListenerC1397a(a aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f18474b = aVar;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f18474b.f18468b.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.f18474b.f18468b.getPageContext().getPageActivity(), this.a.getUserId(), this.a.getUserName())));
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public LinearLayout f18475b;

        /* renamed from: c  reason: collision with root package name */
        public HeadImageView f18476c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f18477d;

        /* renamed from: e  reason: collision with root package name */
        public TbCheckBox f18478e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f18479f;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar, View$OnClickListenerC1397a view$OnClickListenerC1397a) {
            this(aVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void handlerItem(View view, MetaData metaData);
    }

    public a(AtListActivity atListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f18471e = null;
        this.f18472f = null;
        this.f18473g = true;
        this.f18468b = atListActivity;
        this.a = atListActivity.getPageContext().getContext();
        this.f18473g = z;
    }

    public final b b(Object obj, MetaData metaData) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, metaData)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (obj == null) {
                bVar = c(metaData);
            } else {
                bVar = (b) obj;
            }
            bVar.f18475b.setOnClickListener(new View$OnClickListenerC1397a(this, metaData));
            c cVar = this.f18471e;
            if (cVar != null) {
                cVar.handlerItem(bVar.a, metaData);
            }
            String avater = metaData.getAvater();
            bVar.f18477d.setText(metaData.getName_show());
            if (metaData.getIsNearlyAt() == 1) {
                bVar.f18479f.setVisibility(0);
                bVar.f18479f.setText("最近@过");
            } else if (metaData.getIsFollower() == 1) {
                bVar.f18479f.setVisibility(0);
                bVar.f18479f.setText("互相关注");
            } else if (metaData.getIsMyFollower() == 1) {
                bVar.f18479f.setVisibility(0);
                bVar.f18479f.setText("我的关注");
            } else {
                bVar.f18479f.setVisibility(8);
            }
            bVar.f18478e.setTagData(metaData);
            bVar.f18476c.setTag(avater);
            if (this.f18473g) {
                bVar.f18478e.setVisibility(0);
            } else {
                bVar.f18478e.setVisibility(8);
            }
            bVar.f18476c.J(avater, 12, false);
            UtilHelper.showHeadImageViewBigV(bVar.f18476c, metaData);
            this.f18468b.getPageContext().getLayoutMode().k(skinType == 1);
            this.f18468b.getPageContext().getLayoutMode().j(bVar.a);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b c(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData)) == null) {
            b bVar = new b(this, null);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03f7, (ViewGroup) null);
            bVar.a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091827);
            bVar.f18476c = headImageView;
            headImageView.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(bVar.f18476c, metaData);
            bVar.f18475b = (LinearLayout) bVar.a.findViewById(R.id.obfuscated_res_0x7f091829);
            bVar.f18477d = (TextView) bVar.a.findViewById(R.id.obfuscated_res_0x7f092246);
            TextView textView = (TextView) bVar.a.findViewById(R.id.obfuscated_res_0x7f0911a2);
            bVar.f18479f = textView;
            c.a.o0.r.v.c d2 = c.a.o0.r.v.c.d(textView);
            d2.v(R.color.CAM_X0108);
            d2.z(R.dimen.T_X10);
            d2.n(R.string.J_X04);
            d2.l(R.dimen.L_X01);
            d2.k(R.color.CAM_X0111);
            TbCheckBox tbCheckBox = (TbCheckBox) bVar.a.findViewById(R.id.obfuscated_res_0x7f09064d);
            bVar.f18478e = tbCheckBox;
            tbCheckBox.setBackgroundDrawableIdIsWebP(true);
            bVar.f18478e.setBackgroundDrawableId(R.drawable.obfuscated_res_0x7f080998, R.drawable.obfuscated_res_0x7f080997);
            TbCheckBox.b bVar2 = this.f18470d;
            if (bVar2 != null) {
                bVar.f18478e.setStatedChangedListener(bVar2);
            }
            bVar.a.setTag(bVar);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public MetaData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            ArrayList<MetaData> arrayList = this.f18469c;
            if (arrayList != null && i < arrayList.size()) {
                return this.f18469c.get(i);
            }
            return null;
        }
        return (MetaData) invokeI.objValue;
    }

    public void e(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f18470d = bVar;
        }
    }

    public void f(ArrayList<MetaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) {
            this.f18469c = arrayList;
        }
    }

    public void g(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f18471e = cVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            ArrayList<MetaData> arrayList = this.f18469c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view, viewGroup)) == null) {
            if (this.f18472f == null) {
                this.f18472f = viewGroup;
            }
            MetaData item = getItem(i);
            if (item != null) {
                bVar = b(view != null ? view.getTag() : null, item);
            } else {
                bVar = null;
            }
            if (bVar != null) {
                return bVar.a;
            }
            return null;
        }
        return (View) invokeILL.objValue;
    }
}
