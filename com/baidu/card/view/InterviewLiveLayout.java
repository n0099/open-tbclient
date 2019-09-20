package com.baidu.card.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.card.i;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class InterviewLiveLayout extends FrameLayout implements i<a> {
    private a VI;
    private ab<a> WN;
    private boolean Yd;
    private TbImageView Ye;
    private TextView Yf;
    private ArrayList<String> Yg;
    private View.OnClickListener Yh;
    private long forumId;
    private TbImageView.b mOnDrawListener;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.Yd = true;
        this.VI = null;
        this.Yg = new ArrayList<>();
        this.Yh = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.Z(InterviewLiveLayout.this.Yg) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(2010000)) {
                        String str = (String) InterviewLiveLayout.this.Yg.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.Yd ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig createConfig = new ImageViewerConfig(InterviewLiveLayout.this.getContext()).createConfig(InterviewLiveLayout.this.Yg, 0, "", "", "", InterviewLiveLayout.this.Yd, str, false, concurrentHashMap, false);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        createConfig.getIntent().putExtra(IntentConfig.SOURCE_RECT_IN_SCREEN, rect);
                        createConfig.setIsShowHost(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, createConfig));
                        an anVar = new an("c13327");
                        anVar.n("fid", InterviewLiveLayout.this.forumId);
                        anVar.bT(VideoPlayActivityConfig.OBJ_ID, InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(anVar);
                        if (InterviewLiveLayout.this.WN != null) {
                            InterviewLiveLayout.this.WN.a(InterviewLiveLayout.this.Ye, InterviewLiveLayout.this.VI);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), (int) R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.mOnDrawListener = new TbImageView.b() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a qS = c.atK().qS(com.baidu.adp.lib.f.c.iE().e(tbImageView.getUrl(), InterviewLiveLayout.this.Yd ? 13 : 14));
                    if (qS != null) {
                        int width = qS.getWidth();
                        i = qS.getHeight();
                        i2 = width;
                    } else {
                        i = 0;
                        i2 = 0;
                    }
                    if (i2 != 0 && i != 0) {
                        int width2 = (tbImageView.getWidth() - tbImageView.getPaddingLeft()) - tbImageView.getPaddingRight();
                        int height = (tbImageView.getHeight() - tbImageView.getPaddingTop()) - tbImageView.getPaddingBottom();
                        Matrix imageMatrix = tbImageView.getImageMatrix();
                        if (tbImageView.isLongPic() && tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                f4 = height / i;
                            } else {
                                f4 = width2 / i2;
                            }
                            imageMatrix.setScale(f4, f4);
                            imageMatrix.postTranslate(0.0f, 0.0f);
                        } else if (tbImageView.getScaleType() == ImageView.ScaleType.MATRIX) {
                            if (i2 * height > width2 * i) {
                                float f5 = height / i;
                                f2 = f5;
                                f3 = (width2 - (i2 * f5)) * 0.5f;
                                f = 0.0f;
                            } else {
                                float f6 = width2 / i2;
                                f = (height - (i * f6)) * 0.5f;
                                f2 = f6;
                                f3 = 0.0f;
                            }
                            imageMatrix.setScale(f2, f2);
                            if (i > i2) {
                                imageMatrix.postTranslate(f3, 0.0f);
                            } else {
                                imageMatrix.postTranslate(f3, f);
                            }
                        }
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.interview_live_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View findViewById = findViewById(R.id.img_interview_live);
        if (findViewById instanceof TbImageView) {
            this.Ye = (TbImageView) findViewById;
            this.Ye.addCornerFlags(15);
        }
        View findViewById2 = findViewById(R.id.interview_live_tip);
        if (findViewById2 instanceof TextView) {
            this.Yf = (TextView) findViewById2;
        }
    }

    public void setFromCDN(boolean z) {
        this.Yd = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void C(a aVar) {
        this.VI = aVar;
        if (aVar == null || this.Ye == null) {
            setVisibility(8);
            return;
        }
        bh acC = aVar.acC();
        bf aei = acC.aei();
        if (aei == null) {
            setVisibility(8);
            return;
        }
        this.forumId = acC.getFid();
        this.taskId = aei.getTaskId();
        if (com.baidu.tbadk.core.i.ace().aci() && aei != null && !StringUtils.isNull(aei.getThreadImgUrl())) {
            this.Yg.clear();
            this.Yg.add(aei.getThreadImgUrl());
            setVisibility(0);
            this.Ye.setSupportNoImage(true);
            this.Ye.setScaleType(ImageView.ScaleType.MATRIX);
            this.Ye.setOnDrawListener(this.mOnDrawListener);
            this.Ye.startLoad(aei.getThreadImgUrl(), this.Yd ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.af(getContext()) - l.g(getContext(), R.dimen.ds68);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.Ye.setOnClickListener(this.Yh);
    }

    public ab<a> getSubClickListener() {
        return this.WN;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.WN = abVar;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            am.j(this.Yf, R.color.cp_cont_i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.Ye != null) {
            this.Ye.setPageId(bdUniqueId);
        }
    }
}
