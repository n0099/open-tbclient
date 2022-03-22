package c.a.p0.n4.i.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.d.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.PendantData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes2.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<PendantData> a;

    /* renamed from: b  reason: collision with root package name */
    public f f16618b;

    /* renamed from: c  reason: collision with root package name */
    public b f16619c;

    /* renamed from: c.a.p0.n4.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class View$OnClickListenerC1242a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a a;

        public View$OnClickListenerC1242a(a aVar) {
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
                    return;
                }
            }
            this.a = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.a.f16619c == null) {
                return;
            }
            c cVar = (c) view.getTag();
            if (cVar.f16620b.getTag() instanceof Integer) {
                Integer num = (Integer) cVar.f16620b.getTag();
                if (this.a.a.size() <= num.intValue()) {
                    return;
                }
                this.a.f16619c.a(view, num.intValue(), (PendantData) this.a.a.get(num.intValue()));
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(View view, int i, PendantData pendantData);
    }

    /* loaded from: classes2.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f16620b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f16621c;

        public c(a aVar) {
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
    }

    public a(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f16618b = fVar;
    }

    public void c(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        this.a = list;
        notifyDataSetChanged();
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f16619c = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<PendantData> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f16618b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04b0, (ViewGroup) null);
                cVar = new c(this);
                cVar.a = (TextView) view.findViewById(R.id.obfuscated_res_0x7f090715);
                cVar.f16620b = (TbImageView) view.findViewById(R.id.obfuscated_res_0x7f09175c);
                cVar.f16621c = (ProgressBar) view.findViewById(R.id.obfuscated_res_0x7f091760);
                cVar.f16620b.setDefaultBgResource(R.color.transparent);
                cVar.f16620b.setDefaultResource(R.color.CAM_X0101);
                view.setOnClickListener(new View$OnClickListenerC1242a(this));
                view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            PendantData pendantData = this.a.get(i);
            if (pendantData != null) {
                cVar.f16620b.setTag(Integer.valueOf(i));
                int i2 = pendantData.pendantType;
                if (i2 == 0) {
                    cVar.a.setVisibility(0);
                    cVar.f16620b.setVisibility(8);
                    cVar.f16621c.setVisibility(8);
                    cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                    cVar.a.setText("No");
                    cVar.a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
                } else if (i2 == 1) {
                    cVar.a.setVisibility(0);
                    cVar.f16620b.setVisibility(8);
                    cVar.f16621c.setVisibility(8);
                    cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                    cVar.a.setText("T");
                    cVar.a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
                } else if (i2 == 2) {
                    cVar.a.setVisibility(0);
                    cVar.f16620b.setVisibility(8);
                    cVar.f16621c.setVisibility(8);
                    cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                    cVar.a.setText("T");
                    cVar.a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
                } else if (i2 != 3) {
                    cVar.a.setVisibility(8);
                    cVar.f16620b.setVisibility(0);
                    cVar.f16621c.setVisibility(8);
                    cVar.f16620b.J(pendantData.img, 10, false);
                } else {
                    cVar.a.setVisibility(0);
                    cVar.f16620b.setVisibility(8);
                    cVar.f16621c.setVisibility(8);
                    cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                    cVar.a.setText("T");
                    cVar.a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
