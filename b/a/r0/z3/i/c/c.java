package b.a.r0.z3.i.c;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.a.f;
import b.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.video.editvideo.data.MusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f28330e;

    /* renamed from: f  reason: collision with root package name */
    public List<MusicData> f28331f;

    /* renamed from: g  reason: collision with root package name */
    public int f28332g;

    /* renamed from: h  reason: collision with root package name */
    public String f28333h;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f28334a;

        /* renamed from: b  reason: collision with root package name */
        public View f28335b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f28336c;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
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

    public c(f fVar) {
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
        this.f28330e = fVar;
    }

    public void a(TextView textView, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, textView, i2, str) == null) || i2 <= 0) {
            return;
        }
        float g2 = l.g(this.f28330e.getPageActivity(), R.dimen.fontsize24);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(g2);
        while (textPaint.measureText(str) > i2) {
            g2 -= 1.0f;
            textPaint.setTextSize(g2);
        }
        textView.setTextSize(0, g2);
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f28332g : invokeV.intValue;
    }

    public List<MusicData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f28331f : (List) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f28332g = i2;
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f28333h = str;
            if (TextUtils.isEmpty(str) || this.f28331f == null) {
                return;
            }
            int i2 = -1;
            for (int i3 = 0; i3 < this.f28331f.size(); i3++) {
                if (str.equals(this.f28331f.get(i3).id)) {
                    i2 = i3;
                }
            }
            if (i2 == -1) {
                i2 = 1;
            }
            this.f28332g = i2;
        }
    }

    public void f(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.f28331f = list;
        e(this.f28333h);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<MusicData> list = this.f28331f;
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
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            List<MusicData> list = this.f28331f;
            if (list == null) {
                return null;
            }
            return list.get(i2);
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f28330e.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
                aVar = new a(this);
                aVar.f28334a = (TbImageView) view.findViewById(R.id.music_image);
                aVar.f28336c = (TextView) view.findViewById(R.id.music_title);
                aVar.f28335b = view.findViewById(R.id.music_loading);
                aVar.f28334a.setDrawerType(1);
                aVar.f28334a.setIsRound(true);
                aVar.f28334a.setDefaultBgResource(R.color.transparent);
                aVar.f28334a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                aVar.f28334a.setBorderWidth(l.g(this.f28330e.getPageActivity(), R.dimen.ds4));
                aVar.f28334a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                aVar.f28334a.setConrers(15);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            MusicData musicData = this.f28331f.get(i2);
            if (musicData != null) {
                int i3 = musicData.editMusicType;
                if (i3 == 1) {
                    aVar.f28334a.startLoad(String.valueOf(R.drawable.icon_video_mute), 24, false);
                } else if (i3 != 2) {
                    aVar.f28334a.startLoad(musicData.img, 10, false);
                } else {
                    aVar.f28334a.startLoad(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
                }
                aVar.f28335b.setVisibility(4);
                aVar.f28336c.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                aVar.f28336c.setText(musicData.name);
                a(aVar.f28336c, l.g(this.f28330e.getPageActivity(), R.dimen.ds120), musicData.name);
                if (i2 == this.f28332g) {
                    aVar.f28334a.setDrawBorder(true);
                } else {
                    aVar.f28334a.setDrawBorder(false);
                }
                if (i2 == 0) {
                    view.setPadding(l.g(this.f28330e.getPageActivity(), R.dimen.ds34), l.g(this.f28330e.getPageActivity(), R.dimen.ds44), 0, 0);
                } else if (i2 == this.f28331f.size() - 1) {
                    view.setPadding(l.g(this.f28330e.getPageActivity(), R.dimen.ds34), l.g(this.f28330e.getPageActivity(), R.dimen.ds44), l.g(this.f28330e.getPageActivity(), R.dimen.ds34), 0);
                } else {
                    view.setPadding(l.g(this.f28330e.getPageActivity(), R.dimen.ds28), l.g(this.f28330e.getPageActivity(), R.dimen.ds44), 0, 0);
                }
                if (this.f28330e.getPageActivity() instanceof BaseActivity) {
                    ((BaseActivity) this.f28330e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                    ((BaseActivity) this.f28330e.getPageActivity()).getLayoutMode().j(view);
                } else if (this.f28330e.getPageActivity() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.f28330e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                    ((BaseFragmentActivity) this.f28330e.getPageActivity()).getLayoutMode().j(view);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
