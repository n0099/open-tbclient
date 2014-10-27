package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.service.TiebaPrepareImageService;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.widget.EditHeadsImageView;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class EditHeadActivity extends BaseActivity {
    private RadioButton JH;
    private RadioButton JI;
    private LinearLayout JT;
    private int JV;
    private HashMap<String, Bitmap> JW;
    private HashMap<String, ImageView> JX;
    private View JY;
    private NavigationBar mNavigationBar;
    public static String Jv = "resourceid";
    public static String Jw = "pic_info";
    public static String DELET_FLAG = WriteImageActivityConfig.DELET_FLAG;
    public static String Jx = "change";
    public static String FILE_NAME = "file_name";
    private static String[] Jy = null;
    private EditHeadsImageView Jz = null;
    private Bitmap mBitmap = null;
    private int JA = 0;
    private TextView JB = null;
    private Button JC = null;
    private Button JD = null;
    private HorizontalScrollView JE = null;
    private ProgressBar mProgress = null;
    private m JF = null;
    private j JG = null;
    private LinearLayout JJ = null;
    private LinearLayout JK = null;
    private o JL = null;
    private TextView JM = null;
    private Bitmap JN = null;
    private n JO = null;
    private int JP = 0;
    private int JQ = 0;
    private boolean JR = true;
    private String JS = null;
    private boolean JU = false;
    private final Handler mHandler = new Handler();

    public static void a(Activity activity, int i, int i2, Uri uri, AccountData accountData, int i3, String str) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra(WriteImageActivityConfig.FROMCODE, i);
        intent.putExtra("account_data", accountData);
        intent.putExtra("edit_type", i3);
        intent.putExtra(FILE_NAME, str);
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Activity activity, int i, int i2, Uri uri, AccountData accountData, int i3) {
        Intent intent = new Intent(activity, EditHeadActivity.class);
        intent.putExtra(WriteImageActivityConfig.FROMCODE, i);
        intent.putExtra("account_data", accountData);
        intent.putExtra("edit_type", i3);
        intent.setData(uri);
        activity.startActivityForResult(intent, i2);
    }

    public static void a(Activity activity, int i, int i2, Uri uri, AccountData accountData) {
        a(activity, i, i2, uri, accountData, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (com.baidu.adp.lib.b.f.db().U("motu_sdk") == 1 || PluginCenter.getInstance().getNetConfigInfo(PluginNameList.NAME_MOTUSDK) == null) {
            this.JR = false;
        } else {
            this.JR = true;
        }
        TbadkApplication.m251getInst().addRemoteActivity(this);
        setContentView(com.baidu.tieba.w.edit_head_activity);
        Intent intent = getIntent();
        this.JA = intent.getIntExtra("edit_type", 0);
        this.JV = intent.getIntExtra(WriteImageActivityConfig.FROMCODE, 0);
        String stringExtra = intent.getStringExtra(FILE_NAME);
        if (this.JV == 12002 || this.JV == 12001) {
            initUI();
            if (intent.getData() != null) {
                TiebaPrepareImageService.StartService(this.JV, intent.getData(), az.mD().mJ());
            } else {
                TiebaPrepareImageService.StartService(this.JV, null, az.mD().mJ(), 0, stringExtra);
            }
            nY();
        } else {
            initUI();
            initData();
        }
        Jy = getResources().getStringArray(com.baidu.tieba.q.fiter_name);
        if (this.JR) {
            TbadkApplication.m251getInst().sendImagePv(1, 1, "motu_pic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.mNavigationBar.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity
    public void releaseResouce() {
        if (this.JF != null) {
            this.JF.cancel();
        }
        this.Jz.setImageDrawable(null);
        nW();
    }

    private void nW() {
        if (this.JX != null) {
            for (Map.Entry<String, ImageView> entry : this.JX.entrySet()) {
                ImageView value = entry.getValue();
                if (value != null) {
                    value.setImageDrawable(null);
                }
            }
            this.JX.clear();
            this.JX = null;
        }
        if (this.JW != null) {
            for (Map.Entry<String, Bitmap> entry2 : this.JW.entrySet()) {
                Bitmap value2 = entry2.getValue();
                if (value2 != null && !value2.isRecycled()) {
                    value2.recycle();
                }
            }
            this.JW.clear();
            this.JW = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initData() {
        if (this.JF != null) {
            this.JF.cancel();
        }
        this.JF = new m(this, null);
        this.JF.execute(new Object[0]);
        AccountData accountData = (AccountData) getIntent().getSerializableExtra("account_data");
        if (accountData != null) {
            TbadkApplication.setCurrentAccountFromRemoteProcessInUIThread(accountData, getBaseContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        releaseResouce();
        super.onDestroy();
        this.Jz.onDestroy();
        if (this.mBitmap != null && !this.mBitmap.isRecycled()) {
            this.mBitmap.recycle();
            this.mBitmap = null;
        }
        if (this.JL != null) {
            this.JL.cancel();
        }
        if (this.JN != null && !this.JN.isRecycled()) {
            this.JN.recycle();
            this.JN = null;
        }
        if (this.JF != null) {
            this.JF.cancel();
            this.JF = null;
        }
        this.mProgress.setVisibility(8);
        if (this.JV == 12002 || this.JV == 12001) {
            unregisterReceiver(this.JO);
        }
        TbadkApplication.m251getInst().delRemoteActivity(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nX() {
        if (this.JL != null) {
            this.JL.cancel();
        }
        this.JL = new o(this, null);
        this.JL.execute(new String[0]);
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(com.baidu.tieba.v.navigation_bar);
        this.mProgress = (ProgressBar) findViewById(com.baidu.tieba.v.progress);
        this.mProgress.setVisibility(8);
        this.Jz = (EditHeadsImageView) findViewById(com.baidu.tieba.v.image);
        if (this.mBitmap != null) {
            this.Jz.setImageBitmap(this.mBitmap);
        }
        this.JE = (HorizontalScrollView) findViewById(com.baidu.tieba.v.filters_layout);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.JD = (Button) findViewById(com.baidu.tieba.v.show_button);
        this.JD.setOnClickListener(new b(this));
        this.JC = (Button) findViewById(com.baidu.tieba.v.hide_button);
        this.JC.setVisibility(0);
        this.JC.setOnClickListener(new c(this));
        this.JB = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getString(com.baidu.tieba.y.done), new d(this));
        this.JB.setEnabled(false);
        this.JM = this.mNavigationBar.setTitleText(getString(com.baidu.tieba.y.beautify));
        if (this.JA == 2) {
            this.JM.setText(getString(com.baidu.tieba.y.beautify));
            this.JB.setText(getString(com.baidu.tieba.y.done));
        }
        this.JT = (LinearLayout) findViewById(com.baidu.tieba.v.filters);
        this.JP = com.baidu.adp.lib.util.m.dip2px(this, 2.0f);
        this.JK = (LinearLayout) findViewById(com.baidu.tieba.v.beautify_rotate);
        this.JJ = (LinearLayout) findViewById(com.baidu.tieba.v.rotate);
        this.JH = (RadioButton) findViewById(com.baidu.tieba.v.beautify_btn);
        this.JI = (RadioButton) findViewById(com.baidu.tieba.v.rotate_btn);
        f fVar = new f(this);
        this.JH.setOnCheckedChangeListener(fVar);
        this.JI.setOnCheckedChangeListener(fVar);
        this.JH.setChecked(true);
        Button button = (Button) findViewById(com.baidu.tieba.v.rotate_left);
        Button button2 = (Button) findViewById(com.baidu.tieba.v.rotate_right);
        Button button3 = (Button) findViewById(com.baidu.tieba.v.rotate_left_right);
        Button button4 = (Button) findViewById(com.baidu.tieba.v.rotate_up_down);
        button.setTag(0);
        button2.setTag(1);
        button3.setTag(2);
        button4.setTag(3);
        g gVar = new g(this);
        button.setOnClickListener(gVar);
        button2.setOnClickListener(gVar);
        button3.setOnClickListener(gVar);
        button4.setOnClickListener(gVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(String str) {
        if (this.JG != null) {
            this.JG.cancel();
        }
        this.JG = new j(this, null);
        this.JG.execute(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str, Bitmap bitmap) {
        try {
            com.baidu.tbadk.core.util.s.a((String) null, str, bitmap, 80);
            if (this.JU) {
                new au("motu_pic", String.valueOf(this.JQ)).start();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String[] strArr) {
        if (this.JW != null && strArr != null) {
            this.JT.removeAllViews();
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.filter_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(com.baidu.tieba.v.filter_immage);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.v.filter_text);
            int length = strArr.length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                String str = strArr[i];
                String substring = str.substring(0, str.indexOf("|"));
                String substring2 = str.substring(str.indexOf("|") + 1);
                View inflate2 = com.baidu.adp.lib.g.b.ek().inflate(this, com.baidu.tieba.w.filter_item, null);
                ImageView imageView2 = (ImageView) inflate2.findViewById(com.baidu.tieba.v.filter_immage);
                TextView textView2 = (TextView) inflate2.findViewById(com.baidu.tieba.v.filter_text);
                textView2.setText(substring2);
                imageView2.setImageResource(com.baidu.tbadk.coreExtra.view.j.cK(substring));
                imageView2.setTag(textView2);
                int i3 = i2 + 1;
                if (substring.equals(WriteImageActivityConfig.FILTER_NAME_NORMAL)) {
                    imageView2.setOnClickListener(new h(this, substring, i2));
                    this.JY = imageView2;
                } else {
                    imageView2.setOnClickListener(new i(this, substring, i2));
                }
                this.JT.addView(inflate2);
                if (this.JX != null) {
                    this.JX.put(substring, imageView2);
                }
                i++;
                i2 = i3;
            }
            cl(WriteImageActivityConfig.FILTER_NAME_NORMAL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cl(String str) {
        ImageView imageView;
        if (str != null) {
            if (this.JX == null) {
                this.JX = new HashMap<>();
            }
            if (this.JS != null && (imageView = this.JX.get(this.JS)) != null) {
                imageView.setBackgroundDrawable(null);
                imageView.setPadding(this.JP, this.JP, this.JP, this.JP);
                Object tag = imageView.getTag();
                if (tag instanceof TextView) {
                    ((TextView) tag).setSelected(false);
                }
            }
            ImageView imageView2 = this.JX.get(str);
            if (imageView2 != null) {
                imageView2.setBackgroundResource(com.baidu.tieba.u.round_corner);
                imageView2.setPadding(this.JP, this.JP, this.JP, this.JP);
                Object tag2 = imageView2.getTag();
                if (tag2 instanceof TextView) {
                    ((TextView) tag2).setSelected(true);
                }
            }
            this.JS = str;
        }
    }

    private void nY() {
        this.JO = new n(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TbConfig.getBroadcastActionImageResized());
        registerReceiver(this.JO, intentFilter);
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeLoadingDialog();
            setResult(0);
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
