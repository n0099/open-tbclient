package c.a.t0.k4.i.c;

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
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<PendantData> f19058e;

    /* renamed from: f  reason: collision with root package name */
    public f f19059f;

    /* renamed from: g  reason: collision with root package name */
    public b f19060g;

    /* renamed from: c.a.t0.k4.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class View$OnClickListenerC1176a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f19061e;

        public View$OnClickListenerC1176a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f19061e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f19061e.f19060g == null) {
                return;
            }
            c cVar = (c) view.getTag();
            if (cVar.f19062b.getTag() instanceof Integer) {
                Integer num = (Integer) cVar.f19062b.getTag();
                if (this.f19061e.f19058e.size() <= num.intValue()) {
                    return;
                }
                this.f19061e.f19060g.a(view, num.intValue(), (PendantData) this.f19061e.f19058e.get(num.intValue()));
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(View view, int i2, PendantData pendantData);
    }

    /* loaded from: classes7.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TextView a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f19062b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f19063c;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f19059f = fVar;
    }

    public void c(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        this.f19058e = list;
        notifyDataSetChanged();
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f19060g = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<PendantData> list = this.f19058e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        c cVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048581, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f19059f.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
                cVar = new c(this);
                cVar.a = (TextView) view.findViewById(R.id.cover_text);
                cVar.f19062b = (TbImageView) view.findViewById(R.id.pendant_image);
                cVar.f19063c = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
                cVar.f19062b.setDefaultBgResource(R.color.transparent);
                cVar.f19062b.setDefaultResource(R.color.CAM_X0101);
                view.setOnClickListener(new View$OnClickListenerC1176a(this));
                view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            PendantData pendantData = this.f19058e.get(i2);
            if (pendantData != null) {
                cVar.f19062b.setTag(Integer.valueOf(i2));
                int i3 = pendantData.pendantType;
                if (i3 == 0) {
                    cVar.a.setVisibility(0);
                    cVar.f19062b.setVisibility(8);
                    cVar.f19063c.setVisibility(8);
                    cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                    cVar.a.setText("No");
                    cVar.a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
                } else if (i3 == 1) {
                    cVar.a.setVisibility(0);
                    cVar.f19062b.setVisibility(8);
                    cVar.f19063c.setVisibility(8);
                    cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                    cVar.a.setText("T");
                    cVar.a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
                } else if (i3 == 2) {
                    cVar.a.setVisibility(0);
                    cVar.f19062b.setVisibility(8);
                    cVar.f19063c.setVisibility(8);
                    cVar.a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                    cVar.a.setText("T");
                    cVar.a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
                } else if (i3 != 3) {
                    cVar.a.setVisibility(8);
                    cVar.f19062b.setVisibility(0);
                    cVar.f19063c.setVisibility(8);
                    cVar.f19062b.startLoad(pendantData.img, 10, false);
                } else {
                    cVar.a.setVisibility(0);
                    cVar.f19062b.setVisibility(8);
                    cVar.f19063c.setVisibility(8);
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
