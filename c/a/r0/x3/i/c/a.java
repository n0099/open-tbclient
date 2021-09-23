package c.a.r0.x3.i.c;

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
    public List<PendantData> f28938e;

    /* renamed from: f  reason: collision with root package name */
    public f f28939f;

    /* renamed from: g  reason: collision with root package name */
    public b f28940g;

    /* renamed from: c.a.r0.x3.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1348a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f28941e;

        public View$OnClickListenerC1348a(a aVar) {
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
            this.f28941e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f28941e.f28940g == null) {
                return;
            }
            c cVar = (c) view.getTag();
            if (cVar.f28943b.getTag() instanceof Integer) {
                Integer num = (Integer) cVar.f28943b.getTag();
                if (this.f28941e.f28938e.size() <= num.intValue()) {
                    return;
                }
                this.f28941e.f28940g.a(view, num.intValue(), (PendantData) this.f28941e.f28938e.get(num.intValue()));
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
        public TextView f28942a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f28943b;

        /* renamed from: c  reason: collision with root package name */
        public ProgressBar f28944c;

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
        this.f28939f = fVar;
    }

    public void c(List<PendantData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        this.f28938e = list;
        notifyDataSetChanged();
    }

    public void d(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f28940g = bVar;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<PendantData> list = this.f28938e;
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
                view = LayoutInflater.from(this.f28939f.getPageActivity()).inflate(R.layout.layout_pendant_item, (ViewGroup) null);
                cVar = new c(this);
                cVar.f28942a = (TextView) view.findViewById(R.id.cover_text);
                cVar.f28943b = (TbImageView) view.findViewById(R.id.pendant_image);
                cVar.f28944c = (ProgressBar) view.findViewById(R.id.pendant_progressbar);
                cVar.f28943b.setDefaultBgResource(R.color.transparent);
                cVar.f28943b.setDefaultResource(R.color.CAM_X0101);
                view.setOnClickListener(new View$OnClickListenerC1348a(this));
                view.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0201));
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            PendantData pendantData = this.f28938e.get(i2);
            if (pendantData != null) {
                cVar.f28943b.setTag(Integer.valueOf(i2));
                int i3 = pendantData.pendantType;
                if (i3 == 0) {
                    cVar.f28942a.setVisibility(0);
                    cVar.f28943b.setVisibility(8);
                    cVar.f28944c.setVisibility(8);
                    cVar.f28942a.setTextColor(SkinManager.getColor(R.color.CAM_X0110));
                    cVar.f28942a.setText("No");
                    cVar.f28942a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
                } else if (i3 == 1) {
                    cVar.f28942a.setVisibility(0);
                    cVar.f28943b.setVisibility(8);
                    cVar.f28944c.setVisibility(8);
                    cVar.f28942a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                    cVar.f28942a.setText("T");
                    cVar.f28942a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0302));
                } else if (i3 == 2) {
                    cVar.f28942a.setVisibility(0);
                    cVar.f28943b.setVisibility(8);
                    cVar.f28944c.setVisibility(8);
                    cVar.f28942a.setTextColor(SkinManager.getColor(R.color.CAM_X0111));
                    cVar.f28942a.setText("T");
                    cVar.f28942a.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0109));
                } else if (i3 != 3) {
                    cVar.f28942a.setVisibility(8);
                    cVar.f28943b.setVisibility(0);
                    cVar.f28944c.setVisibility(8);
                    cVar.f28943b.startLoad(pendantData.img, 10, false);
                } else {
                    cVar.f28942a.setVisibility(0);
                    cVar.f28943b.setVisibility(8);
                    cVar.f28944c.setVisibility(8);
                    cVar.f28942a.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
                    cVar.f28942a.setText("T");
                    cVar.f28942a.setBackgroundDrawable(SkinManager.getDrawable(R.drawable.bg_cover_text_border));
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
