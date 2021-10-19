package c.a.r0.y3.i.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import c.a.e.a.f;
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
/* loaded from: classes4.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<PendantData> f29114e;

    /* renamed from: f  reason: collision with root package name */
    public f f29115f;

    /* renamed from: g  reason: collision with root package name */
    public b f29116g;

    /* renamed from: c.a.r0.y3.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1357a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f29117e;

        public View$OnClickListenerC1357a(a aVar) {
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
            this.f29117e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f29117e.f29116g == null) {
                return;
            }
            c cVar = (c) view.getTag();
            if (cVar.f29119b.getTag() instanceof Integer) {
                Integer num = (Integer) cVar.f29119b.getTag();
                if (this.f29117e.f29114e.size() <= num.intValue()) {
                    return;
                }
                this.f29117e.f29116g.a(view, num.intValue(), (PendantData) this.f29117e.f29114e.get(num.intValue()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(View view, int i2, PendantData pendantData);
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TextView f29118a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f29119b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f29120c;

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
        this.f29115f = fVar;
    }

    public void c(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        this.f29114e = list;
        notifyDataSetChanged();
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f29116g = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<PendantData> list = this.f29114e;
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
                view = LayoutInflater.from(this.f29115f.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
                cVar = new c(this);
                cVar.f29118a = (TextView) view.findViewById(R.id.cover_text);
                cVar.f29119b = (TbImageView) view.findViewById(R.id.pendant_image);
                cVar.f29120c = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
                cVar.f29119b.setDefaultBgResource(R.color.transparent);
                cVar.f29119b.setDefaultResource(R.color.CAM_X0101);
                view.setOnClickListener(new View$OnClickListenerC1357a(this));
                view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            PendantData pendantData = this.f29114e.get(i2);
            if (pendantData != null) {
                cVar.f29119b.setTag(Integer.valueOf(i2));
                int i3 = pendantData.pendantType;
                if (i3 == 0) {
                    cVar.f29118a.setVisibility(0);
                    cVar.f29119b.setVisibility(8);
                    cVar.f29120c.setVisibility(8);
                    cVar.f29118a.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                    cVar.f29118a.setText("No");
                    cVar.f29118a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
                } else if (i3 == 1) {
                    cVar.f29118a.setVisibility(0);
                    cVar.f29119b.setVisibility(8);
                    cVar.f29120c.setVisibility(8);
                    cVar.f29118a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                    cVar.f29118a.setText("T");
                    cVar.f29118a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
                } else if (i3 == 2) {
                    cVar.f29118a.setVisibility(0);
                    cVar.f29119b.setVisibility(8);
                    cVar.f29120c.setVisibility(8);
                    cVar.f29118a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                    cVar.f29118a.setText("T");
                    cVar.f29118a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
                } else if (i3 != 3) {
                    cVar.f29118a.setVisibility(8);
                    cVar.f29119b.setVisibility(0);
                    cVar.f29120c.setVisibility(8);
                    cVar.f29119b.startLoad(pendantData.img, 10, false);
                } else {
                    cVar.f29118a.setVisibility(0);
                    cVar.f29119b.setVisibility(8);
                    cVar.f29120c.setVisibility(8);
                    cVar.f29118a.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                    cVar.f29118a.setText("T");
                    cVar.f29118a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
