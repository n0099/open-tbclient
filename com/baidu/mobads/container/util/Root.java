package com.baidu.mobads.container.util;

import android.os.Build;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class Root {

    /* loaded from: classes2.dex */
    public static class ExecShell {

        /* loaded from: classes2.dex */
        public enum ShellCMD {
            check_su_binary(new String[]{"/system/xbin/which", "su"});
            
            public String[] command;

            ShellCMD(String[] strArr) {
                this.command = strArr;
            }
        }

        public ArrayList<String> executeCommand(ShellCMD shellCMD) {
            ArrayList<String> arrayList = new ArrayList<>();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(shellCMD.command).getInputStream()));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                    } catch (Exception unused) {
                    }
                }
                return arrayList;
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    public boolean checkRootMethod1() {
        String str = Build.TAGS;
        return str != null && str.contains("test-keys");
    }

    public boolean checkRootMethod2() {
        try {
            return new File("/system/app/Superuser.apk").exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public boolean checkRootMethod3() {
        return new ExecShell().executeCommand(ExecShell.ShellCMD.check_su_binary) != null;
    }

    public boolean isDeviceRooted() {
        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
    }
}
