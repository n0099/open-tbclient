package c.a.r0.b4.k.h;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import c.a.e.a.f;
import c.a.e.e.p.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.cloudmusic.data.CloudMusicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public f f16286e;

    /* renamed from: f  reason: collision with root package name */
    public List<CloudMusicData.MusicTagList.MusicList> f16287f;

    /* renamed from: g  reason: collision with root package name */
    public c f16288g;

    /* renamed from: h  reason: collision with root package name */
    public String f16289h;

    /* renamed from: c.a.r0.b4.k.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class View$OnClickListenerC0781a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CloudMusicData.MusicTagList.MusicList f16290e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f16291f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f16292g;

        public View$OnClickListenerC0781a(a aVar, CloudMusicData.MusicTagList.MusicList musicList, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, musicList, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f16292g = aVar;
            this.f16290e = musicList;
            this.f16291f = i2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f16292g.f16288g == null) {
                return;
            }
            this.f16292g.f16288g.onMusicChooseClick(view, this.f16290e.resource, this.f16291f);
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public TbImageView f16293a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f16294b;

        /* renamed from: c  reason: collision with root package name */
        public View f16295c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f16296d;

        /* renamed from: e  reason: collision with root package name */
        public TextView f16297e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f16298f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f16299g;

        /* renamed from: h  reason: collision with root package name */
        public View f16300h;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public void b(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                SkinManager.setViewTextColor(this.f16296d, R.color.CAM_X0105);
                SkinManager.setViewTextColor(this.f16297e, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f16298f, R.color.CAM_X0107);
                SkinManager.setViewTextColor(this.f16299g, R.color.CAM_X0302);
                SkinManager.setBackgroundResource(this.f16299g, R.drawable.bg_music_choose);
                SkinManager.setBackgroundColor(this.f16300h, R.color.CAM_X0204);
                SkinManager.setImageResource(this.f16294b, R.drawable.btn_icon_play_video_n);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void onMusicChooseClick(View view, String str, int i2);
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
        this.f16289h = "";
        this.f16286e = fVar;
        this.f16287f = new ArrayList();
    }

    public void b(List<CloudMusicData.MusicTagList.MusicList> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        for (CloudMusicData.MusicTagList.MusicList musicList : list) {
            if (!this.f16287f.contains(musicList)) {
                this.f16287f.add(musicList);
            }
        }
        notifyDataSetChanged();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: c */
    public CloudMusicData.MusicTagList.MusicList getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? this.f16287f.get(i2) : (CloudMusicData.MusicTagList.MusicList) invokeI.objValue;
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.f16289h = str;
        }
    }

    public void e(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cVar) == null) {
            this.f16288g = cVar;
        }
    }

    public void f(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            getItem(i2).isLoading = z;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f16287f.size() : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? i2 : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, view, viewGroup)) == null) {
            if (view == null) {
                view = LayoutInflater.from(this.f16286e.getPageActivity()).inflate(R.layout.cloud_music_item, viewGroup, false);
                bVar = new b();
                bVar.f16294b = (TbImageView) view.findViewById(R.id.music_state);
                TbImageView tbImageView = (TbImageView) view.findViewById(R.id.music_image);
                bVar.f16293a = tbImageView;
                tbImageView.setDrawerType(1);
                bVar.f16293a.setIsRound(true);
                bVar.f16293a.setDefaultResource(R.drawable.bg_video_cloudmusic);
                bVar.f16293a.setDefaultBgResource(R.color.transparent);
                bVar.f16293a.setBorderWidth(l.g(this.f16286e.getPageActivity(), R.dimen.ds4));
                bVar.f16293a.setBorderColor(SkinManager.getColor(R.color.CAM_X0302));
                bVar.f16293a.setConrers(15);
                bVar.f16295c = view.findViewById(R.id.music_loading);
                bVar.f16296d = (TextView) view.findViewById(R.id.music_title);
                bVar.f16297e = (TextView) view.findViewById(R.id.music_author_name);
                bVar.f16298f = (TextView) view.findViewById(R.id.music_duration);
                bVar.f16299g = (TextView) view.findViewById(R.id.music_choose);
                bVar.f16300h = view.findViewById(R.id.line);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            bVar.b(TbadkCoreApplication.getInst().getSkinType());
            CloudMusicData.MusicTagList.MusicList musicList = this.f16287f.get(i2);
            if (musicList != null) {
                bVar.f16296d.setText(musicList.name);
                bVar.f16293a.startLoad(musicList.image, 10, false);
                bVar.f16297e.setText(musicList.author);
                bVar.f16298f.setText(StringHelper.stringForVideoTime(musicList.duration * 1000));
                if (musicList.isLoading) {
                    bVar.f16295c.setVisibility(0);
                } else {
                    bVar.f16295c.setVisibility(4);
                }
                if (musicList.equals(c.a.r0.b4.k.i.a.b().a())) {
                    bVar.f16294b.setImageResource(R.drawable.btn_icon_stop_video);
                    bVar.f16293a.setDrawBorder(true);
                    bVar.f16299g.setVisibility(0);
                    bVar.f16295c.setVisibility(4);
                    musicList.isLoading = false;
                    bVar.f16299g.setOnClickListener(new View$OnClickListenerC0781a(this, musicList, i2));
                } else if (c.a.r0.b4.k.i.a.b().a() == null && getItem(i2) != null && !TextUtils.isEmpty(this.f16289h) && this.f16289h.equals(String.valueOf(getItem(i2).music_id))) {
                    bVar.f16294b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.f16293a.setDrawBorder(true);
                    bVar.f16299g.setVisibility(8);
                    bVar.f16295c.setVisibility(4);
                    musicList.isLoading = false;
                } else {
                    bVar.f16294b.setImageResource(R.drawable.btn_icon_play_video_n);
                    bVar.f16293a.setDrawBorder(false);
                    bVar.f16299g.setVisibility(8);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }
}
