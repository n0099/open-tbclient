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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.a;
import com.baidu.tbadk.core.data.bf;
import com.baidu.tbadk.core.data.bh;
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
    private a EX;
    private ab<a> Gd;
    private ArrayList<String> HA;
    private View.OnClickListener HB;
    private TbImageView.b HC;
    private boolean Hx;
    private TbImageView Hy;
    private TextView Hz;
    private long forumId;
    private int mSkinType;
    private String taskId;

    public InterviewLiveLayout(Context context) {
        this(context, null);
    }

    public InterviewLiveLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.Hx = true;
        this.EX = null;
        this.HA = new ArrayList<>();
        this.HB = new View.OnClickListener() { // from class: com.baidu.card.view.InterviewLiveLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (v.getCount(InterviewLiveLayout.this.HA) > 0) {
                    if (TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD)) {
                        String str = (String) InterviewLiveLayout.this.HA.get(0);
                        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.urlType = InterviewLiveLayout.this.Hx ? 13 : 14;
                        imageUrlData.imageUrl = str;
                        imageUrlData.originalUrl = str;
                        imageUrlData.originalSize = 0L;
                        imageUrlData.isLongPic = false;
                        imageUrlData.mIsShowOrigonButton = false;
                        imageUrlData.threadId = 0L;
                        imageUrlData.postId = 0L;
                        concurrentHashMap.put(str, imageUrlData);
                        ImageViewerConfig createConfig = new ImageViewerConfig(InterviewLiveLayout.this.getContext()).createConfig(InterviewLiveLayout.this.HA, 0, "", "", "", InterviewLiveLayout.this.Hx, str, false, concurrentHashMap, false);
                        createConfig.getIntent().putExtra("from", "frs");
                        Rect rect = new Rect();
                        view.getGlobalVisibleRect(rect);
                        createConfig.getIntent().putExtra("source_rect_in_screen", rect);
                        createConfig.setIsShowHost(false);
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.IMAGE_VIEWER_CUSTOM_CMD, createConfig));
                        an anVar = new an("c13327");
                        anVar.p("fid", InterviewLiveLayout.this.forumId);
                        anVar.bS("obj_id", InterviewLiveLayout.this.taskId);
                        TiebaStatic.log(anVar);
                        if (InterviewLiveLayout.this.Gd != null) {
                            InterviewLiveLayout.this.Gd.a(InterviewLiveLayout.this.Hy, InterviewLiveLayout.this.EX);
                            return;
                        }
                        return;
                    }
                    l.showToast(InterviewLiveLayout.this.getContext(), (int) R.string.plugin_image_viewer_install_error_tips);
                }
            }
        };
        this.HC = new TbImageView.b() { // from class: com.baidu.card.view.InterviewLiveLayout.2
            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void a(TbImageView tbImageView, Canvas canvas) {
                int i;
                int i2;
                float f;
                float f2;
                float f3;
                float f4;
                if (tbImageView != null && tbImageView.getImageMatrix() != null) {
                    com.baidu.adp.widget.ImageView.a pY = c.avs().pY(com.baidu.adp.lib.f.c.fT().genCacheKey(tbImageView.getUrl(), InterviewLiveLayout.this.Hx ? 13 : 14));
                    if (pY != null) {
                        int width = pY.getWidth();
                        i = pY.getHeight();
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
            this.Hy = (TbImageView) findViewById;
            this.Hy.ko(15);
        }
        View findViewById2 = findViewById(R.id.interview_live_tip);
        if (findViewById2 instanceof TextView) {
            this.Hz = (TextView) findViewById2;
        }
    }

    public void setFromCDN(boolean z) {
        this.Hx = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.card.i
    /* renamed from: a */
    public void z(a aVar) {
        this.EX = aVar;
        if (aVar == null || this.Hy == null) {
            setVisibility(8);
            return;
        }
        bh agG = aVar.agG();
        bf aik = agG.aik();
        if (aik == null) {
            setVisibility(8);
            return;
        }
        this.forumId = agG.getFid();
        this.taskId = aik.getTaskId();
        if (com.baidu.tbadk.core.i.ago().isShowImages() && aik != null && !StringUtils.isNull(aik.getThreadImgUrl())) {
            this.HA.clear();
            this.HA.add(aik.getThreadImgUrl());
            setVisibility(0);
            this.Hy.setSupportNoImage(true);
            this.Hy.setScaleType(ImageView.ScaleType.MATRIX);
            this.Hy.setOnDrawListener(this.HC);
            this.Hy.startLoad(aik.getThreadImgUrl(), this.Hx ? 13 : 14, false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            layoutParams.width = l.getEquipmentWidth(getContext()) - l.getDimens(getContext(), R.dimen.ds68);
            layoutParams.height = (int) ((layoutParams.width * 428.0f) / 760.0f);
            setLayoutParams(layoutParams);
        } else {
            setVisibility(8);
        }
        this.Hy.setOnClickListener(this.HB);
    }

    public ab<a> getSubClickListener() {
        return this.Gd;
    }

    public void setSubClickListener(ab<a> abVar) {
        this.Gd = abVar;
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (i != this.mSkinType) {
            am.setViewTextColor(this.Hz, (int) R.color.cp_cont_i);
        }
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        if (this.Hy != null) {
            this.Hy.setPageId(bdUniqueId);
        }
    }
}
