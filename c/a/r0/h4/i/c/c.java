package c.a.r0.h4.i.c;

import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.d.a.f;
import c.a.d.f.p.l;
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
    public f f17947e;

    /* renamed from: f  reason: collision with root package name */
    public List<MusicData> f17948f;

    /* renamed from: g  reason: collision with root package name */
    public int f17949g;

    /* renamed from: h  reason: collision with root package name */
    public String f17950h;

    /* loaded from: classes6.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;

        /* renamed from: b  reason: collision with root package name */
        public View f17951b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f17952c;

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
        this.f17947e = fVar;
    }

    public void a(TextView textView, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048576, this, textView, i2, str) == null) || i2 <= 0) {
            return;
        }
        float f2 = l.f(this.f17947e.getPageActivity(), R.dimen.fontsize24);
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(f2);
        while (textPaint.measureText(str) > i2) {
            f2 -= 1.0f;
            textPaint.setTextSize(f2);
        }
        textView.setTextSize(0, f2);
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f17949g : invokeV.intValue;
    }

    public List<MusicData> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f17948f : (List) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f17949g = i2;
            notifyDataSetChanged();
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f17950h = str;
            if (TextUtils.isEmpty(str) || this.f17948f == null) {
                return;
            }
            int i2 = -1;
            for (int i3 = 0; i3 < this.f17948f.size(); i3++) {
                if (str.equals(this.f17948f.get(i3).id)) {
                    i2 = i3;
                }
            }
            if (i2 == -1) {
                i2 = 1;
            }
            this.f17949g = i2;
        }
    }

    public void f(List<MusicData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        this.f17948f = list;
        e(this.f17950h);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            List<MusicData> list = this.f17948f;
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
            List<MusicData> list = this.f17948f;
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
                view = LayoutInflater.from(this.f17947e.getPageActivity()).inflate(R.layout.layout_music_item, (ViewGroup) null);
                aVar = new a(this);
                aVar.a = (TbImageView) view.findViewById(R.id.music_image);
                aVar.f17952c = (TextView) view.findViewById(R.id.music_title);
                aVar.f17951b = view.findViewById(R.id.music_loading);
                aVar.a.setDrawerType(1);
                aVar.a.setIsRound(true);
                aVar.a.setDefaultBgResource(R.color.transparent);
                aVar.a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                aVar.a.setBorderWidth(l.f(this.f17947e.getPageActivity(), R.dimen.ds4));
                aVar.a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                aVar.a.setConrers(15);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            MusicData musicData = this.f17948f.get(i2);
            if (musicData != null) {
                int i3 = musicData.editMusicType;
                if (i3 == 1) {
                    aVar.a.startLoad(String.valueOf(R.drawable.icon_video_mute), 24, false);
                } else if (i3 != 2) {
                    aVar.a.startLoad(musicData.img, 10, false);
                } else {
                    aVar.a.startLoad(String.valueOf(R.drawable.icon_video_cloudmusic), 24, false);
                }
                aVar.f17951b.setVisibility(4);
                aVar.f17952c.setTextColor(SkinManager.getColor(R.color.CAM_X0107));
                aVar.f17952c.setText(musicData.name);
                a(aVar.f17952c, l.f(this.f17947e.getPageActivity(), R.dimen.ds120), musicData.name);
                if (i2 == this.f17949g) {
                    aVar.a.setDrawBorder(true);
                } else {
                    aVar.a.setDrawBorder(false);
                }
                if (i2 == 0) {
                    view.setPadding(l.f(this.f17947e.getPageActivity(), R.dimen.ds34), l.f(this.f17947e.getPageActivity(), R.dimen.ds44), 0, 0);
                } else if (i2 == this.f17948f.size() - 1) {
                    view.setPadding(l.f(this.f17947e.getPageActivity(), R.dimen.ds34), l.f(this.f17947e.getPageActivity(), R.dimen.ds44), l.f(this.f17947e.getPageActivity(), R.dimen.ds34), 0);
                } else {
                    view.setPadding(l.f(this.f17947e.getPageActivity(), R.dimen.ds28), l.f(this.f17947e.getPageActivity(), R.dimen.ds44), 0, 0);
                }
                if (this.f17947e.getPageActivity() instanceof BaseActivity) {
                    ((BaseActivity) this.f17947e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                    ((BaseActivity) this.f17947e.getPageActivity()).getLayoutMode().j(view);
                } else if (this.f17947e.getPageActivity() instanceof BaseFragmentActivity) {
                    ((BaseFragmentActivity) this.f17947e.getPageActivity()).getLayoutMode().k(TbadkCoreApplication.getInst().getSkinType() == 1);
                    ((BaseFragmentActivity) this.f17947e.getPageActivity()).getLayoutMode().j(view);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
