package com.baidu.searchbox.ui.common;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.Adapter;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.UIRuntime;
/* loaded from: classes4.dex */
public class IndexScroller {
    public static final int INDEXBAR_WIDTH = 30;
    public static final int PREVIEW_PADDING = 5;
    public static final int PREVIEW_TEXT_SIZE = 50;
    public static final int SECTION_HEIGHT = 16;
    public static final int SECTION_TEXT_SIZE = 12;
    public static final int STATE_HIDDEN = 0;
    public static final int STATE_HIDING = 3;
    public static final int STATE_SHOWING = 1;
    public static final int STATE_SHOWN = 2;
    public float mAlphaRate;
    public boolean mAutoHide;
    public Canvas mCanvas;
    public int mCurrentSection;
    public float mDensity;
    @SuppressLint({"HandlerLeak"})
    public Handler mHandler;
    public float mIndexbarMargin;
    public RectF mIndexbarRect;
    public float mIndexbarWidth;
    public SectionIndexer mIndexer;
    public boolean mIsIndexing;
    public ListView mListView;
    public int mListViewHeight;
    public int mListViewWidth;
    public float mPreviewPadding;
    public int mPreviewTextColor;
    public String[] mSections;
    public int mState;

    public IndexScroller(ListView listView) {
        this.mState = 0;
        this.mCurrentSection = -1;
        this.mIsIndexing = false;
        this.mListView = null;
        this.mIndexer = null;
        this.mSections = null;
        this.mAutoHide = false;
        this.mPreviewTextColor = NightModeHelper.getNightModeSwitcherState() ? Color.parseColor("#666666") : -1;
        this.mHandler = new Handler() { // from class: com.baidu.searchbox.ui.common.IndexScroller.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = IndexScroller.this.mState;
                if (i != 1) {
                    if (i == 2) {
                        IndexScroller.this.setState(3);
                        return;
                    } else if (i == 3) {
                        IndexScroller indexScroller = IndexScroller.this;
                        indexScroller.mAlphaRate = (float) (indexScroller.mAlphaRate - (IndexScroller.this.mAlphaRate * 0.4d));
                        if (IndexScroller.this.mAlphaRate < 0.1d) {
                            IndexScroller.this.mAlphaRate = 0.0f;
                            IndexScroller.this.setState(0);
                            return;
                        }
                        IndexScroller.this.mListView.invalidate();
                        IndexScroller.this.fade(10L);
                        return;
                    } else {
                        return;
                    }
                }
                IndexScroller indexScroller2 = IndexScroller.this;
                indexScroller2.mAlphaRate = (float) (indexScroller2.mAlphaRate + ((1.0f - IndexScroller.this.mAlphaRate) * 0.4d));
                if (IndexScroller.this.mAlphaRate > 0.9d) {
                    IndexScroller.this.mAlphaRate = 1.0f;
                    IndexScroller.this.setState(2);
                    return;
                }
                IndexScroller.this.mListView.invalidate();
                IndexScroller.this.fade(10L);
            }
        };
        this.mDensity = DeviceUtil.ScreenInfo.getDensity(UIRuntime.getAppContext());
        this.mListView = listView;
        setAdapter(listView.getAdapter());
        float f = this.mDensity;
        this.mIndexbarWidth = 30.0f * f;
        this.mIndexbarMargin = 0.0f * f;
        this.mPreviewPadding = f * 5.0f;
        this.mIndexbarRect = new RectF();
    }

    public IndexScroller(ListView listView, boolean z) {
        this(listView);
        this.mAutoHide = z;
    }

    public boolean contains(float f, float f2) {
        RectF rectF = this.mIndexbarRect;
        if (f >= rectF.left) {
            float f3 = rectF.top;
            if (f2 >= f3 && f2 <= f3 + rectF.height()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fade(long j) {
        this.mHandler.removeMessages(0);
        this.mHandler.sendEmptyMessageAtTime(0, SystemClock.uptimeMillis() + j);
    }

    private int getSectionByPoint(float f) {
        String[] strArr = this.mSections;
        if (strArr == null || strArr.length == 0) {
            return 0;
        }
        RectF rectF = this.mIndexbarRect;
        float f2 = rectF.top;
        if (f < f2) {
            return 0;
        }
        if (f >= rectF.bottom) {
            return strArr.length - 1;
        }
        return (int) ((f - f2) / (rectF.height() / this.mSections.length));
    }

    public void onNightModeChanged(boolean z) {
        int i;
        if (z) {
            i = Color.parseColor("#666666");
        } else {
            i = -1;
        }
        this.mPreviewTextColor = i;
    }

    public void setAdapter(Adapter adapter) {
        if (adapter instanceof SectionIndexer) {
            SectionIndexer sectionIndexer = (SectionIndexer) adapter;
            this.mIndexer = sectionIndexer;
            this.mSections = (String[]) sectionIndexer.getSections();
        } else if (adapter instanceof HeaderViewListAdapter) {
            ListAdapter wrappedAdapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            if (wrappedAdapter instanceof SectionIndexer) {
                SectionIndexer sectionIndexer2 = (SectionIndexer) wrappedAdapter;
                this.mIndexer = sectionIndexer2;
                this.mSections = (String[]) sectionIndexer2.getSections();
            }
        }
        show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setState(int i) {
        if (i >= 0 && i <= 3) {
            this.mState = i;
            if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            this.mAlphaRate = 1.0f;
                            fade(3000L);
                            return;
                        }
                        return;
                    }
                    this.mHandler.removeMessages(0);
                    return;
                }
                this.mAlphaRate = 0.0f;
                fade(0L);
                return;
            }
            this.mHandler.removeMessages(0);
        }
    }

    public void draw(Canvas canvas) {
        String[] strArr;
        this.mCanvas = canvas;
        if (canvas != null && this.mState != 0 && (strArr = this.mSections) != null && strArr.length > 0) {
            int i = this.mCurrentSection;
            int i2 = 0;
            if (i >= 0 && i < strArr.length) {
                Paint paint = new Paint();
                paint.setColor(-16777216);
                paint.setAlpha(96);
                paint.setAntiAlias(true);
                paint.setShadowLayer(3.0f, 0.0f, 0.0f, Color.argb(64, 0, 0, 0));
                Paint paint2 = new Paint();
                paint2.setColor(this.mPreviewTextColor);
                paint2.setAntiAlias(true);
                paint2.setTextSize(this.mDensity * 50.0f);
                float measureText = paint2.measureText(this.mSections[this.mCurrentSection]);
                float descent = ((this.mPreviewPadding * 2.0f) + paint2.descent()) - paint2.ascent();
                int i3 = this.mListViewWidth;
                int i4 = this.mListViewHeight;
                RectF rectF = new RectF((i3 - descent) / 2.0f, (i4 - descent) / 2.0f, ((i3 - descent) / 2.0f) + descent, ((i4 - descent) / 2.0f) + descent);
                float f = this.mDensity;
                canvas.drawRoundRect(rectF, f * 5.0f, f * 5.0f, paint);
                canvas.drawText(this.mSections[this.mCurrentSection], (rectF.left + ((descent - measureText) / 2.0f)) - 1.0f, ((rectF.top + this.mPreviewPadding) - paint2.ascent()) + 1.0f, paint2);
            }
            Paint paint3 = new Paint();
            paint3.setColor(Color.parseColor("#666666"));
            paint3.setAlpha((int) (this.mAlphaRate * 255.0f));
            paint3.setAntiAlias(true);
            paint3.setTextSize(this.mDensity * 12.0f);
            float f2 = this.mDensity * 16.0f;
            float descent2 = (f2 - (paint3.descent() - paint3.ascent())) / 2.0f;
            while (true) {
                String[] strArr2 = this.mSections;
                if (i2 < strArr2.length) {
                    String str = this.mSections[i2];
                    RectF rectF2 = this.mIndexbarRect;
                    canvas.drawText(str, rectF2.left + ((this.mIndexbarWidth - paint3.measureText(strArr2[i2])) / 2.0f), ((rectF2.top + (i2 * f2)) + descent2) - paint3.ascent(), paint3);
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    public SectionIndexer getIndexer() {
        return this.mIndexer;
    }

    public void hide() {
        if (this.mState == 2 && this.mAutoHide) {
            setState(3);
        }
    }

    public void onDetachedFromWindow() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeMessages(0);
        }
    }

    public void show() {
        int i = this.mState;
        if (i == 0) {
            setState(1);
        } else if (i == 3) {
            setState(3);
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        String[] strArr;
        if (this.mSections == null) {
            return;
        }
        this.mListViewWidth = i;
        this.mListViewHeight = i2;
        float f = i2;
        float length = (f - ((this.mDensity * 16.0f) * strArr.length)) / 2.0f;
        this.mIndexbarMargin = length;
        float f2 = i;
        this.mIndexbarRect.set(f2 - this.mIndexbarWidth, length, f2, f - length);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && this.mIsIndexing) {
                    if (contains(motionEvent.getX(), motionEvent.getY())) {
                        int sectionByPoint = getSectionByPoint(motionEvent.getY());
                        this.mCurrentSection = sectionByPoint;
                        int positionForSection = this.mIndexer.getPositionForSection(sectionByPoint);
                        if (positionForSection != -1) {
                            ListView listView = this.mListView;
                            listView.setSelection(listView.getHeaderViewsCount() + positionForSection);
                        }
                    }
                    return true;
                }
            } else {
                if (this.mIsIndexing) {
                    this.mIsIndexing = false;
                    this.mCurrentSection = -1;
                }
                if (this.mState == 2 && this.mAutoHide) {
                    setState(3);
                }
            }
        } else if (this.mState != 0 && contains(motionEvent.getX(), motionEvent.getY())) {
            setState(2);
            this.mIsIndexing = true;
            int sectionByPoint2 = getSectionByPoint(motionEvent.getY());
            this.mCurrentSection = sectionByPoint2;
            int positionForSection2 = this.mIndexer.getPositionForSection(sectionByPoint2);
            if (positionForSection2 != -1) {
                ListView listView2 = this.mListView;
                listView2.setSelection(listView2.getHeaderViewsCount() + positionForSection2);
            }
            return true;
        }
        return false;
    }
}
