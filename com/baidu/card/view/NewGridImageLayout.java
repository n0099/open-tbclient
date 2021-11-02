package com.baidu.card.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.l;
import b.a.l.p;
import b.a.q0.s.k;
import b.a.q0.s.q.d2;
import b.a.r0.b0.c0;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.VoteView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.layout.GridImageLayout;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tbadk.widget.tiejia.TiePlusEventController;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
/* loaded from: classes7.dex */
public class NewGridImageLayout extends LinearLayout implements p<b.a.q0.s.q.a>, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean canCenterStart;

    /* renamed from: e  reason: collision with root package name */
    public final int f36790e;

    /* renamed from: f  reason: collision with root package name */
    public Context f36791f;

    /* renamed from: g  reason: collision with root package name */
    public b.a.q0.s.q.a f36792g;

    /* renamed from: h  reason: collision with root package name */
    public String f36793h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f36794i;
    public boolean isUseInCard;
    public boolean j;
    public c0<b.a.q0.s.q.a> k;
    public boolean l;
    public LinkedList<MediaData> m;
    public TextView mAbstract;
    public GridImageLayout mGridImageLayout;
    public TextView mTitle;
    public PlayVoiceBntNew mVoiceBtn;
    public VoteView mVoteView;
    public b.a.q0.f1.n.a n;
    public View.OnClickListener o;
    public boolean p;
    public int q;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f36795e;

        public a(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36795e = newGridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c0<b.a.q0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f36795e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("2");
            subClickListener.a(view, this.f36795e.f36792g);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f36796e;

        public b(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36796e = newGridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c0<b.a.q0.s.q.a> subClickListener;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (subClickListener = this.f36796e.getSubClickListener()) == null) {
                return;
            }
            view.setTag("1");
            subClickListener.a(view, this.f36796e.f36792g);
        }
    }

    /* loaded from: classes7.dex */
    public class c implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f36797a;

        public c(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36797a = newGridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.startImageViewer(view, this.f36797a.f36794i ? true : this.f36797a.n.r, this.f36797a.m, i2, this.f36797a.f36792g.getThreadData(), this.f36797a.f36793h, this.f36797a.j);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.a.q0.s.q.a f36798e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f36799f;

        public d(NewGridImageLayout newGridImageLayout, b.a.q0.s.q.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36799f = newGridImageLayout;
            this.f36798e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                ThreadCardUtils.jumpToPB(this.f36798e.getThreadData().y1, this.f36799f.f36791f, this.f36799f.q);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f36800a;

        public e(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36800a = newGridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.jumpToPB(this.f36800a.f36792g.getThreadData().y1, this.f36800a.f36791f, 2);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements TbRichTextView.z {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f36801a;

        public f(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36801a = newGridImageLayout;
        }

        @Override // com.baidu.tbadk.widget.richText.TbRichTextView.z
        public void a(View view, String str, int i2, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, str, Integer.valueOf(i2), Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
                ThreadCardUtils.startImageViewer(view, true, this.f36801a.m, i2, this.f36801a.f36792g.getThreadData().y1.a(), this.f36801a.f36793h, this.f36801a.f36792g.getThreadData().y1.o);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ NewGridImageLayout f36802e;

        public g(NewGridImageLayout newGridImageLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {newGridImageLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36802e = newGridImageLayout;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f36802e.o == null) {
                return;
            }
            this.f36802e.o.onClick(view);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1813834781, "Lcom/baidu/card/view/NewGridImageLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1813834781, "Lcom/baidu/card/view/NewGridImageLayout;");
                return;
            }
        }
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds26);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds31);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds16);
        l.g(TbadkCoreApplication.getInst(), R.dimen.tbds7);
        l.g(TbadkCoreApplication.getInst(), R.dimen.M_H_X004);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public NewGridImageLayout(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void setVoiceData(d2 d2Var) {
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65548, this, d2Var) == null) || d2Var == null) {
            return;
        }
        if (this.l) {
            this.mVoiceBtn.ovverideClickListener(new g(this));
        }
        ArrayList<VoiceData$VoiceModel> D1 = (!d2Var.z1 || (originalThreadInfo = d2Var.y1) == null) ? d2Var.D1() : originalThreadInfo.q;
        if (ListUtils.isEmpty(D1)) {
            this.mVoiceBtn.setVisibility(8);
            return;
        }
        this.mVoiceBtn.setVisibility(0);
        VoiceData$VoiceModel voiceData$VoiceModel = D1.get(0);
        this.mVoiceBtn.setVoiceModel(voiceData$VoiceModel);
        this.mVoiceBtn.setTag(voiceData$VoiceModel);
        this.mVoiceBtn.changeSkin();
        if (voiceData$VoiceModel != null) {
            this.mVoiceBtn.refreshViewState(voiceData$VoiceModel.voice_status.intValue());
        }
        this.mVoiceBtn.resetLayoutParams();
    }

    public c0<b.a.q0.s.q.a> getSubClickListener() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.k : (c0) invokeV.objValue;
    }

    public boolean isNeedFrsTabName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.p : invokeV.booleanValue;
    }

    public final void j(d2 d2Var) {
        boolean z;
        String k;
        OriginalThreadInfo originalThreadInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d2Var) == null) {
            ArrayList<MediaData> E0 = d2Var.E0();
            String X = d2Var.X();
            if (!d2Var.z1 || (originalThreadInfo = d2Var.y1) == null) {
                z = false;
            } else if (originalThreadInfo.m) {
                this.mGridImageLayout.setVisibility(8);
                return;
            } else {
                E0 = originalThreadInfo.f45042h;
                z = true;
            }
            if (k.c().g() && ListUtils.getCount(E0) != 0) {
                this.m.clear();
                for (int i2 = 0; i2 < E0.size(); i2++) {
                    MediaData mediaData = (MediaData) ListUtils.getItem(E0, i2);
                    if (mediaData != null && mediaData.getType() == 3) {
                        if (!z) {
                            if (X != null) {
                                if (!X.equals(mediaData.getPostId() + "")) {
                                }
                            }
                        }
                        this.m.add(mediaData);
                    }
                }
                if (ListUtils.getCount(this.m) > 0) {
                    this.mGridImageLayout.setVisibility(0);
                    ArrayList<TbRichTextImageInfo> arrayList = new ArrayList<>();
                    for (int i3 = 0; i3 < this.m.size(); i3++) {
                        MediaData mediaData2 = (MediaData) ListUtils.getItem(this.m, i3);
                        String originalUrl = mediaData2.getOriginalUrl();
                        if (this.m.size() > 1) {
                            k = l(mediaData2);
                        } else {
                            k = k(mediaData2);
                        }
                        TbRichTextImageInfo tbRichTextImageInfo = new TbRichTextImageInfo();
                        tbRichTextImageInfo.I(k);
                        tbRichTextImageInfo.H(originalUrl);
                        tbRichTextImageInfo.G(mediaData2.isLongPic());
                        int i4 = mediaData2.picWidth;
                        if (i4 > 0 && mediaData2.picHeight > 0) {
                            tbRichTextImageInfo.setWidth(i4);
                            tbRichTextImageInfo.setHeight(mediaData2.picHeight);
                        }
                        arrayList.add(tbRichTextImageInfo);
                    }
                    this.mGridImageLayout.setData(arrayList);
                    return;
                }
                this.mGridImageLayout.setVisibility(8);
                return;
            }
            this.mGridImageLayout.setVisibility(8);
        }
    }

    public final String k(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mediaData)) == null) {
            if (mediaData == null) {
                return "";
            }
            String picUrl = mediaData.getPicUrl();
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getThumbnails_url();
            }
            if (TextUtils.isEmpty(picUrl)) {
                picUrl = mediaData.getSmallPicUrl();
            }
            return TextUtils.isEmpty(picUrl) ? mediaData.getSrc_pic() : picUrl;
        }
        return (String) invokeL.objValue;
    }

    public final String l(MediaData mediaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mediaData)) == null) {
            if (mediaData == null) {
                return "";
            }
            String smallPicUrl = mediaData.getSmallPicUrl();
            if (TextUtils.isEmpty(smallPicUrl)) {
                smallPicUrl = mediaData.getThumbnails_url();
            }
            if (TextUtils.isEmpty(smallPicUrl)) {
                smallPicUrl = mediaData.getPicUrl();
            }
            return TextUtils.isEmpty(smallPicUrl) ? mediaData.getSrc_pic() : smallPicUrl;
        }
        return (String) invokeL.objValue;
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.new_grid_image_layout, (ViewGroup) this, true);
            setClipChildren(false);
            setClipToPadding(false);
            setOrientation(1);
            setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.mAbstract = (TextView) findViewById(R.id.thread_card_abstract);
            this.mTitle = (TextView) findViewById(R.id.thread_card_title);
            PlayVoiceBntNew playVoiceBntNew = (PlayVoiceBntNew) findViewById(R.id.thread_card_voice);
            this.mVoiceBtn = playVoiceBntNew;
            playVoiceBntNew.setAfterClickListener(new a(this));
            GridImageLayout gridImageLayout = (GridImageLayout) findViewById(R.id.thread_card_img_more_container);
            this.mGridImageLayout = gridImageLayout;
            gridImageLayout.setSupportGifPlay(false);
            this.mGridImageLayout.setCornerStyle(1);
            this.mGridImageLayout.setAfterClickListener(new b(this));
            this.n = new b.a.q0.f1.n.a();
            int i2 = l.p(this.f36791f)[0];
            this.n.G = (i2 - (l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X004) * 2)) - (l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.M_W_X005) * 2);
            this.n.H = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10);
            this.mGridImageLayout.setLayoutStrategy(this.n);
            this.m = new LinkedList<>();
            this.mGridImageLayout.setOnImageClickListener(new c(this));
            VoteView voteView = (VoteView) findViewById(R.id.thread_card_vote);
            this.mVoteView = voteView;
            voteView.setBgColor(R.color.CAM_X0207);
        }
    }

    public final boolean n(ArrayList<MediaData> arrayList, ArrayList<MediaData> arrayList2) {
        InterceptResult invokeLL;
        String k;
        String k2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, arrayList, arrayList2)) == null) {
            if (arrayList == arrayList2) {
                return true;
            }
            if (arrayList == null || arrayList2 == null || arrayList.size() != arrayList2.size()) {
                return false;
            }
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                MediaData mediaData = arrayList.get(i2);
                MediaData mediaData2 = arrayList2.get(i2);
                if (size > 1) {
                    k = l(mediaData);
                    k2 = l(mediaData2);
                } else {
                    k = k(mediaData);
                    k2 = k(mediaData2);
                }
                if (k != k2 && (k == null || k2 == null || !k.equals(k2))) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public final boolean o(PollData pollData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, pollData)) == null) ? (pollData == null || pollData.getOptions() == null || pollData.getOptions().size() <= 0) ? false : true : invokeL.booleanValue;
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i2) == null) {
            GridImageLayout gridImageLayout = this.mGridImageLayout;
            if (gridImageLayout != null) {
                gridImageLayout.onChangeSkinType();
            }
            VoteView voteView = this.mVoteView;
            if (voteView != null) {
                voteView.onChangeSkinType(i2);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, view) == null) || (onClickListener = this.o) == null) {
            return;
        }
        onClickListener.onClick(view);
    }

    public final void p(View view, int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048588, this, view, i2) == null) && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (marginLayoutParams.topMargin != i2) {
                marginLayoutParams.topMargin = i2;
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    public final boolean q(d2 d2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, d2Var)) == null) {
            b.a.q0.s.q.a aVar = this.f36792g;
            if (aVar == null || aVar.getThreadData() == null) {
                return true;
            }
            if (this.f36792g.getThreadData().s1() == null || this.f36792g.getThreadData().s1().equals(d2Var.s1())) {
                if (d2Var.z1 && d2Var.y1 != null) {
                    if (this.f36792g.getThreadData().y1 == null) {
                        return true;
                    }
                    return !n(d2Var.y1.f45042h, this.f36792g.getThreadData().y1.f45042h);
                }
                return !n(d2Var.E0(), this.f36792g.getThreadData().E0());
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setCornerStyle(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.mGridImageLayout.setCornerStyle(i2);
        }
    }

    public void setDynamicCard(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.j = z;
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            this.f36793h = str;
        }
    }

    public void setFromCDN(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048593, this, z) == null) {
            this.f36794i = z;
        }
    }

    public void setFromForPb(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.q = i2;
        }
    }

    public void setJumpToPbListener(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, onClickListener) == null) {
            this.o = onClickListener;
        }
    }

    public void setNeedFrsTabName(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048596, this, z) == null) {
            this.p = z;
        }
    }

    public void setObjectPool(b.a.e.e.k.b<ImageView> bVar, b.a.e.e.k.b<GifView> bVar2) {
        GridImageLayout gridImageLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, bVar, bVar2) == null) || (gridImageLayout = this.mGridImageLayout) == null) {
            return;
        }
        gridImageLayout.setObjectPool(bVar, bVar2);
    }

    public void setPreloadSizeReadyCallback(b.a.e.l.c.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, bVar) == null) {
        }
    }

    public void setSubClickListener(c0<b.a.q0.s.q.a> c0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, c0Var) == null) {
            this.k = c0Var;
        }
    }

    public void setTransmit(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.l = z;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewGridImageLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f36790e = l.k(TbadkCoreApplication.getInst()) - ((l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2);
        this.f36794i = true;
        this.j = true;
        this.l = false;
        this.isUseInCard = true;
        this.canCenterStart = false;
        this.p = false;
        this.f36791f = context;
        m();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.l.p
    public void onBindDataToView(b.a.q0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) || aVar == null || aVar.getThreadData() == null) {
            return;
        }
        d2 threadData = aVar.getThreadData();
        OriginalThreadInfo originalThreadInfo = threadData.y1;
        if (originalThreadInfo != null && this.l) {
            p(this.mGridImageLayout, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
            b.a.q0.s.u.c d2 = b.a.q0.s.u.c.d(this.mAbstract);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X07);
            b.a.q0.s.u.c.d(this.mTitle).z(R.dimen.T_X07);
            this.mTitle.setVisibility(8);
            if (!originalThreadInfo.m && !threadData.L4()) {
                SpannableString b2 = originalThreadInfo.b();
                ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, b2, threadData, this.f36790e, this.l, this.p);
                if (b2 != null) {
                    TiePlusEventController.tryExposeTiePlusLinkEvent(originalThreadInfo.e());
                }
            } else {
                ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, new SpannableString(this.f36791f.getString(R.string.origin_thread_deleted_title)), threadData, this.f36790e, this.l, this.p);
                SkinManager.setViewTextColor(this.mAbstract, R.color.CAM_X0108);
            }
            if (o(originalThreadInfo.F)) {
                d dVar = new d(this, aVar);
                this.mVoteView.setOnClickListener(dVar);
                this.mVoteView.setOnItemClickListener(dVar);
                this.mVoteView.setIsTransmit(true);
                this.mVoteView.setData(originalThreadInfo.F, originalThreadInfo.f45040f, originalThreadInfo.f45039e);
                this.mVoteView.setVisibility(0);
            } else {
                this.mVoteView.setVisibility(8);
            }
        } else {
            p(this.mGridImageLayout, UtilHelper.getDimenPixelSize(R.dimen.M_H_X007));
            this.mVoteView.setVisibility(8);
            this.mAbstract.setTextSize(0, l.g(this.f36791f, R.dimen.T_X06));
            this.mAbstract.setLineSpacing(l.g(this.f36791f, R.dimen.M_T_X002), 1.0f);
            this.mTitle.setTextSize(0, l.g(this.f36791f, R.dimen.T_X06));
            ThreadCardUtils.setTitle(this.mTitle, threadData, this.p);
            SpannableString p = threadData.p();
            ThreadCardUtils.setAbstract(this.mAbstract, this.mTitle, p, threadData, this.f36790e, this.l, this.p);
            if (p != null) {
                TiePlusEventController.tryExposeTiePlusLinkEvent(threadData.t1());
            }
        }
        if (q(threadData)) {
            j(threadData);
        }
        setVoiceData(threadData);
        this.f36792g = aVar;
        if (aVar.getThreadData().y1 == null) {
            return;
        }
        if (threadData.z1) {
            if (this.f36792g.getThreadData().y1 == null) {
                return;
            }
            if (!this.f36792g.getThreadData().y1.m) {
                this.mGridImageLayout.setOnImageClickListener(new e(this));
            }
        }
        if (!this.f36792g.getThreadData().y1.m) {
            this.mGridImageLayout.setOnImageClickListener(new f(this));
        }
        if (this.l) {
            if (this.f36792g.getThreadData().y1 != null && !this.f36792g.getThreadData().y1.m) {
                setOnClickListener(this);
            } else {
                setOnClickListener(null);
            }
            setClickable(true);
            return;
        }
        setOnClickListener(null);
        setClickable(false);
    }
}
