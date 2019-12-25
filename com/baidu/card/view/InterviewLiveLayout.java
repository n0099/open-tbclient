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
import com.baidu.card.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.imageManager.c;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes5.dex */
public class InterviewLiveLayout extends FrameLayout implements m<a> {
    private a JB;
    private z<a> Lb;
    private boolean Nf;
    private TbImageView Ng;
    private LinearLayout Nh;
    private ImageView Ni;
    private TextView Nj;
    private ArrayList<String> Nk;
    private bj Nl;
    private View.OnClickListener Nm;
    private TbImageView.c Nn;
    private long forumId;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.Nf = true;
        this.JB = null;
        this.Nk = new ArrayList<>();
        this.Nm = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.getCount(InterviewLiveLayout.this.Nk) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                        String str = (String) InterviewLiveLayout.this.Nk.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.Nf ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig createConfig = new ImageViewerConfig(InterviewLiveLayout.this.getContext()).createConfig(InterviewLiveLayout.this.Nk, 0, "", "", "", InterviewLiveLayout.this.Nf, str, false, concurrentHashMap, false);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        createConfig.getIntent().putExtra("source_rect_in_screen", rect);
                        createConfig.setIsShowHost(false);
                        createConfig.setThreadData(InterviewLiveLayout.this.Nl);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        an anVar = new an("c13327");
                        anVar.s("fid", InterviewLiveLayout.this.forumId);
                        anVar.cp("obj_id", InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(anVar);
                        if (InterviewLiveLayout.this.Lb != null) {
                            InterviewLiveLayout.this.Lb.a(InterviewLiveLayout.this.Ng, InterviewLiveLayout.this.JB);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), (int) R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.Nn = new TbImageView.c() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a vb = c.aMZ().vb(com.baidu.adp.lib.e.c.gs().genCacheKey(tbImageView.getUrl(), InterviewLiveLayout.this.Nf ? 13 : 14));
                    if (vb != null) {
                        int width = vb.getWidth();
                        i = vb.getHeight();
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

            @Override // com.baidu.tbadk.widget.TbImageView.c
            public void b(TbImageView tbImageView, Canvas canvas) {
            }
        };
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(getContext()).inflate(R.layout.interview_live_layout, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.Ng = (TbImageView) findViewById(R.id.img_interview_live);
        this.Ng.mD(15);
        this.Ng.setPlaceHolder(3);
        this.Nh = (LinearLayout) findViewById(R.id.interview_live_tip_bg);
        this.Ni = (ImageView) findViewById(R.id.interview_live_tip_img);
        this.Nj = (TextView) findViewById(R.id.interview_live_tip);
        onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setFromCDN(boolean z) {
        this.Nf = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.m
    /* renamed from: b */
    public void A(a aVar) {
        this.JB = aVar;
        if (aVar == null || this.Ng == null) {
            setVisibility(8);
            return;
        }
        bj axx = aVar.axx();
        bh azj = axx.azj();
        if (azj == null) {
            setVisibility(8);
            return;
        }
        this.Nl = axx;
        this.forumId = axx.getFid();
        this.taskId = azj.getTaskId();
        if (i.axf().isShowImages() && azj != null && !StringUtils.isNull(azj.getThreadImgUrl())) {
            this.Nk.clear();
            this.Nk.add(azj.getThreadImgUrl());
            setVisibility(0);
            this.Ng.setSupportNoImage(true);
            this.Ng.setScaleType(ImageView.ScaleType.MATRIX);
            this.Ng.setOnDrawListener(this.Nn);
            this.Ng.startLoad(azj.getThreadImgUrl(), this.Nf ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.tbds88);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.Ng.setOnClickListener(this.Nm);
    }

    public void setSubClickListener(z<a> zVar) {
        this.Lb = zVar;
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType) {
            am.setViewTextColor(this.Nj, (int) R.color.cp_cont_a);
            am.setImageResource(this.Ni, R.drawable.interview_live_circle_share);
            am.setBackgroundResource(this.Nh, R.drawable.interview_live_circle_bg_shape);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.Ng != null) {
            this.Ng.setPageId(bdUniqueId);
        }
    }
}
